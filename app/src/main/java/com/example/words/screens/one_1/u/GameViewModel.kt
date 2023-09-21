package com.example.words.screens.one_1.u

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.words.screens.one_1.data.MAX_NO_OF_WORDS
import com.example.words.screens.one_1.data.SCORE_INCREASE
import com.example.words.screens.one_1.data.allWords
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    // состояние пользовательского интерфейса игры
    private val _uiState = MutableStateFlow(GameUState())
    val uiState: StateFlow<GameUState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    // Набор слов, используемых в игре
    private var usedWords: MutableSet<String> = mutableSetOf()
    private lateinit var currentWord: String
    init {
        resetGame()
    }

//Повторно инициализирует игровые данные, чтобы перезапустить игру.
fun resetGame() {
    usedWords.clear()
    _uiState.value = GameUState(currentScrambledWord = pickRandomWordAndShuffle())
}

//Обновите предположение пользователя
fun updateUserGuess(guessedWord: String){
    userGuess = guessedWord
}
    fun checkUserGuess() {
        if (userGuess.equals(currentWord, ignoreCase = true)) {
            // Предположение пользователя верно, увеличьте
            //и вызовите updateGameState(), чтобы подготовить игру к следующему раунду
            val updatedScore = _uiState.value.score.plus(SCORE_INCREASE)
            updateGameState(updatedScore)
        } else {
            // Предположение пользователя неверно, отображается сообщение об ошибке
            _uiState.update { currentState ->
                currentState.copy(isGuessedWordWrong = true)
            }
        }
        // Сбросить предположение пользователя
        updateUserGuess("")
    }


// Перейти к следующему слову
fun skipWord() {
    updateGameState(_uiState.value.score)
    // Сбросить предположение пользователя
    updateUserGuess("")
}

    private fun updateGameState(updatedScore: Int) {
        if (usedWords.size == MAX_NO_OF_WORDS){
            //Последний раунд в игре, обновление - игра окончена до true, не выбирайте новое слово
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    score = updatedScore,
                    isGameOver = true
                )
            }
        } else{
            // Обычный раунд в игре
            _uiState.update { currentState ->
                currentState.copy(
                    isGuessedWordWrong = false,
                    currentScrambledWord = pickRandomWordAndShuffle(),
                    currentWordCount = currentState.currentWordCount.inc(),
                    score = updatedScore
                )
            }
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        // Скремблируйте слово
        tempWord.shuffle()
        while (String(tempWord) == word) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    private fun pickRandomWordAndShuffle(): String {
        // Продолжайте подбирать новое случайное слово, пока не получите то, которое раньше не использовалось
        currentWord = allWords.random()
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }

}