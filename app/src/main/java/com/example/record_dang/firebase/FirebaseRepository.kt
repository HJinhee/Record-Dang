package com.example.record_dang.firebase

import android.content.SharedPreferences

object FirebaseRepository {
    private const val FB_KEY = "FB_TOKEN"
    private lateinit var preferences: SharedPreferences

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var fireBaseToken: String
        get() = preferences.getString(FB_KEY, "Firebase") ?: ""
        set(value) = preferences.edit { it.putString(FB_KEY, value) }
}