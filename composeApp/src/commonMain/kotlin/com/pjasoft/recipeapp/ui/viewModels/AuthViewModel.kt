package com.pjasoft.recipeapp.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pjasoft.recipeapp.data.ktorfitClient
import com.pjasoft.recipeapp.domain.dtos.Login
import com.pjasoft.recipeapp.domain.dtos.Register
import com.pjasoft.recipeapp.domain.utils.Preferences
import de.jensklingenberg.ktorfit.ktorfit
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel(){

    var isLoading by mutableStateOf(false)
        private set

    fun register(
        name : String,
        email : String,
        password : String,
        onResult: (Boolean, String) -> Unit
    ){
        viewModelScope.launch {
            try {
                isLoading = true
                val service = ktorfitClient.createAuthService()
                val register = Register(name, email, password)
                val result = service.register(register)

                if(result.isLogged){
                    Preferences.saveUserId(result.userId)
                    Preferences.saveIsLogged(result.isLogged)
                    onResult(true,result.message)
                } else {
                    onResult(false,result.message)
                }
            } catch (e : Exception){
                onResult(false, "Error al registrarte")
            } finally {
                isLoading = false
            }
        }
    }

    fun login(
        email: String,
        password: String,
        onResult: (Boolean, String) -> Unit
    ){
        viewModelScope.launch {
            try {
                isLoading = true
                val service = ktorfitClient.createAuthService()
                val login = Login(email, password)
                val result = service.login(login)
                if (result.isLogged){
                    Preferences.saveUserId(result.userId)
                    Preferences.saveIsLogged(result.isLogged)
                    onResult(true, result.message)
                } else {
                    onResult(false, result.message )
                }
            }
            catch (e :  Exception){
                onResult(false, "Error al loguearse")
            } finally {
                isLoading = false
            }
        }
    }
}
