package com.bluetooth.padeltournamets.utilities.session

import android.content.Context
import android.content.SharedPreferences
import com.bluetooth.padeltournamets.presentation.viewmodel.OrganizatorViewModel
import com.bluetooth.padeltournamets.presentation.viewmodel.UserViewModel

class LoginPref {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con: Context
    var PRIVATEMODE : Int = 0

    constructor(con: Context){
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME, PRIVATEMODE)
        editor = pref.edit()
    }

    companion object{
        val KEY_ID = "id"
        val PREF_NAME = "Login_Preference"
        val IS_LOGIN = "isLoggedin"
        val KEY_USERNAME = "username"
        val KEY_EMAIL = "email"
        val KEY_ROL = "rol"
    }

    fun createLoginSession(id:Int, username:String, email:String, rol : String){
        editor.putString(KEY_ID, id.toString())
        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_USERNAME, username)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_ROL, rol)
        editor.commit()
    }

    fun getUserDetails(): Map<String, String> {
        var user : Map<String,String> = HashMap<String, String>()
        pref.getString(KEY_ID,null)?.let { (user as HashMap).put(KEY_ID, it) }
        pref.getString(KEY_USERNAME,null)?.let { (user as HashMap).put(KEY_USERNAME, it) }
        pref.getString(KEY_EMAIL, null)?.let { (user as HashMap).put(KEY_EMAIL, it) }
        pref.getString(KEY_ROL, null)?.let { (user as HashMap).put(KEY_ROL, it) }

        return user
    }

    fun LogoutUser(userViewModel: UserViewModel){
        editor.clear()
        editor.commit()
        userViewModel._usr.value=null
    }

    fun isLoggedIn():Boolean{
        return pref.getBoolean(IS_LOGIN, false)
    }
}