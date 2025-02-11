package com.rmso.irecipe.presentation.features.home

import com.rmso.irecipe.domain.model.recipe.Instruction
import com.rmso.irecipe.domain.model.recipe.Ratings
import com.rmso.irecipe.domain.model.recipe.Recipe
import com.rmso.irecipe.domain.model.recipe.Tag

val mockRecipeList = listOf(
    Recipe(
        description = "This chicken salad is a lunchtime delight! Packed with creamy avocado," +
            " tender chicken, and crunchy veggies, it's a healthy and satisfying meal that" +
            " won't weigh you down. Tossed in a tangy yogurt dressing with a hint of spice," +
            " it's a flavor explosion that's perfect for a light meal.",
        id = 1,
        instructions = listOf(
            Instruction(
                "In a blender or food processor, " +
                        "combine the yogurt, lime juice, pepper, " +
                        "and chili powder and pulse to combine. Add ½ of" +
                        " the avocado and blend until creamy."
            ),
            Instruction(
                "In a medium bowl, combine the chicken," +
                        " yogurt sauce, celery, the remaining ½ avocado," +
                        " onion, and salt. Mix until well combined."
            )
        ),
        name = "Low-Carb Avocado Chicken Salad",
        originalVideoUrl = "https://s3.amazonaws.com/video-api/FixedFBFinal.mp4",
        prepTimeMinutes = 15,
        tags = listOf(
            Tag(
                displayName = "Italian",
                id = 1,
                name = "italian",
                type = "european"
            ),
            Tag(
                displayName = "Stove Top",
                id = 2,
                name = "stove_top",
                type = "appliance"
            )
        ),
        thumbnailUrl = "https://img.buzzfeed.com/thumbnailer-p/FixedFBFinal.jpg",
        userRatings = Ratings(0.918)
    ),
    Recipe(
        description = "This chicken salad is a lunchtime delight! Packed with " +
                "creamy avocado, tender chicken, and crunchy veggies, " +
                "it's a healthy and satisfying meal that won't weigh you down. " +
                "Tossed in a tangy yogurt dressing with a hint of spice, it's a " +
                "flavor explosion that's perfect for a light meal.",
        id = 1,
        instructions = listOf(
            Instruction(
                "In a blender or food processor, combine the yogurt, " +
                        "lime juice, pepper, and chili powder and pulse to combine." +
                        " Add ½ of the avocado and blend until creamy."
            ),
            Instruction(
                "In a medium bowl, combine the chicken, yogurt sauce, " +
                        "celery, the remaining ½ avocado, onion, and salt. Mix until well combined."
            )
        ),
        name = "Low-Carb Avocado Chicken Salad",
        originalVideoUrl = "https://s3.amazonaws.com/video-api-prod/assets/a0e1b07dc71c4ac6b378f24493ae2d85/FixedFBFinal.mp4",
        prepTimeMinutes = 15,
        tags = listOf(
            Tag(
                displayName = "Italian",
                id = 1,
                name = "italian",
                type = "european"
            ),
            Tag(
                displayName = "Stove Top",
                id = 2,
                name = "stove_top",
                type = "appliance"
            )
        ),
        thumbnailUrl = "https://img.buzzfeed.com/thumbnailer-prod-us-east-1/45b4efeb5d2c4d29970344ae165615ab/FixedFBFinal.jpg",
        userRatings = Ratings(0.918)
    )
)

val mockTagList = listOf(
    Tag(
        displayName = "Italian",
        id = 1,
        name = "italian",
        type = "european"
    ),
    Tag(
        displayName = "Stove Top",
        id = 2,
        name = "stove_top",
        type = "appliance"
    ),
    Tag(
        displayName = "Vegetarian",
        id = 3,
        name = "vegetarian",
        type = "dietary"
    ),
    Tag(
        displayName = "Kid-Friendly",
        id = 4,
        name = "kid-friendly",
        type = "cooking_style"
    )
)
