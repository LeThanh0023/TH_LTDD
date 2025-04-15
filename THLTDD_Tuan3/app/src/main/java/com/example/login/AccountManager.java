package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public class AccountManager {
    private static final String PREF_NAME = "accounts";
    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;

    public AccountManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public boolean isAccountExists(String email) {
        return preferences.contains(email);
    }

    public void saveAccount(String email, String password) {
        editor.putString(email, password);
        editor.apply();
    }

    public String getPassword(String email) {
        return preferences.getString(email, null);
    }

    public boolean validateLogin(String email, String password) {
        String savedPass = getPassword(email);
        return savedPass != null && savedPass.equals(password);
    }

    public void saveRemembered(String email, String password) {
        editor.putString("lastEmail", email);
        editor.putString("lastPassword", password);
        editor.apply();
    }

    public Map<String, ?> getAllAccounts() {
        return preferences.getAll();
    }
    public void deleteAccount(String email) {
        if (isAccountExists(email)) {
            editor.remove(email);
            editor.apply();
        }
    }
}