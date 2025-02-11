package com.rmso.irecipe.presentation.features.details.navigation

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.rmso.irecipe.domain.model.recipe.Recipe
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object CustomRecipeNavType {
    val RecipeType = object : NavType<Recipe>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Recipe? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Recipe {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun put(bundle: Bundle, key: String, value: Recipe) {
            bundle.putString(key, Json.encodeToString(value))
        }

        override fun serializeAsValue(value: Recipe): String {
            return Uri.encode(Json.encodeToString(value))
        }
    }
}
