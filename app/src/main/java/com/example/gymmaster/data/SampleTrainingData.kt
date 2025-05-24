package com.example.gymmaster.data

import com.example.gymmaster.R
import com.example.gymmaster.data.models.*

object SampleTrainingData {
    val chestExercises = listOf(
        Exercise(
            id = "bench_press",
            nameResId = R.string.exercise_bench_press,
            descriptionResId = R.string.exercise_bench_press_desc,
            imageResId = R.drawable.inclinebechpress,
            gifResId = R.drawable.penchpress,
            youtubeLink = "https://www.youtube.com/watch?v=rT7DgCr-3pg",
            targetMuscle = Muscle.CHEST,
            sets = 3,
            reps = "12-15",
            restSeconds = 90
        ),
        Exercise(
            id = "incline_dumbbell_press",
            nameResId = R.string.exercise_incline_dumbbell_press,
            descriptionResId = R.string.exercise_incline_dumbbell_press_desc,
            imageResId = R.drawable.inclinebechpress,
            gifResId = R.drawable.inclinebechpress,
            youtubeLink = "https://www.youtube.com/watch?v=8iPEnn-ltC8",
            targetMuscle = Muscle.CHEST,
            sets = 3,
            reps = "12-15",
            restSeconds = 90
        ),
        Exercise(
            id = "dumbbell_flyes",
            nameResId = R.string.exercise_dumbbell_flyes,
            descriptionResId = R.string.exercise_dumbbell_flyes_desc,
            imageResId = R.drawable.dumbleflys,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=eozdVDA78K0",
            targetMuscle = Muscle.CHEST,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "pushups",
            nameResId = R.string.exercise_pushups,
            descriptionResId = R.string.exercise_pushups_desc,
            imageResId = R.drawable.pushupsgif,
            gifResId = R.drawable.pushupsgif,
            youtubeLink = "https://www.youtube.com/watch?v=IODxDxX7oi4",
            targetMuscle = Muscle.CHEST,
            sets = 4,
            reps = "Until failure",
            restSeconds = 60
        ),
        Exercise(
            id = "cable_crossover",
            nameResId = R.string.exercise_cable_crossover,
            descriptionResId = R.string.exercise_cable_crossover_desc,
            imageResId = R.drawable.cablecrossover,
            gifResId = R.drawable.cablecrossover,
            youtubeLink = "https://www.youtube.com/watch?v=taI4XduLpTk",
            targetMuscle = Muscle.CHEST,
            sets = 3,
            reps = "15-20",
            restSeconds = 60
        )
    )

    val backExercises = listOf(
        Exercise(
            id = "pullups",
            nameResId = R.string.exercise_pullups,
            descriptionResId = R.string.exercise_pullups_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_settings,
            youtubeLink = "https://www.youtube.com/watch?v=eGo4IYlbE5g",
            targetMuscle = Muscle.BACK,
            sets = 4,
            reps = "8-12",
            restSeconds = 90
        ),
        Exercise(
            id = "barbell_rows",
            nameResId = R.string.exercise_barbell_rows,
            descriptionResId = R.string.exercise_barbell_rows_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=9efgcAjQe7E",
            targetMuscle = Muscle.BACK,
            sets = 3,
            reps = "10-12",
            restSeconds = 90
        ),
        Exercise(
            id = "lat_pulldown",
            nameResId = R.string.exercise_lat_pulldown,
            descriptionResId = R.string.exercise_lat_pulldown_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=CAwf7n6Luuc",
            targetMuscle = Muscle.BACK,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "seated_cable_rows",
            nameResId = R.string.exercise_seated_cable_rows,
            descriptionResId = R.string.exercise_seated_cable_rows_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=GZbfZ033f74",
            targetMuscle = Muscle.BACK,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "face_pulls",
            nameResId = R.string.exercise_face_pulls,
            descriptionResId = R.string.exercise_face_pulls_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=rep-qVOkqgk",
            targetMuscle = Muscle.BACK,
            sets = 3,
            reps = "15-20",
            restSeconds = 45
        )
    )

    val shoulderExercises = listOf(
        Exercise(
            id = "overhead_press",
            nameResId = R.string.exercise_overhead_press,
            descriptionResId = R.string.exercise_overhead_press_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=2yjwXTZQDDI",
            targetMuscle = Muscle.SHOULDERS,
            sets = 4,
            reps = "8-12",
            restSeconds = 90
        ),
        Exercise(
            id = "lateral_raises",
            nameResId = R.string.exercise_lateral_raises,
            descriptionResId = R.string.exercise_lateral_raises_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=3VcKaXpzqRo",
            targetMuscle = Muscle.SHOULDERS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "front_raises",
            nameResId = R.string.exercise_front_raises,
            descriptionResId = R.string.exercise_front_raises_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=sOcYlBI0WDU",
            targetMuscle = Muscle.SHOULDERS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "reverse_flyes",
            nameResId = R.string.exercise_reverse_flyes,
            descriptionResId = R.string.exercise_reverse_flyes_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=9R5f4oIjwq8",
            targetMuscle = Muscle.SHOULDERS,
            sets = 3,
            reps = "15-20",
            restSeconds = 45
        ),
        Exercise(
            id = "shrugs",
            nameResId = R.string.exercise_shrugs,
            descriptionResId = R.string.exercise_shrugs_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=cJRVVxmytaM",
            targetMuscle = Muscle.SHOULDERS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        )
    )

    val bicepsExercises = listOf(
        Exercise(
            id = "barbell_curls",
            nameResId = R.string.exercise_barbell_curls,
            descriptionResId = R.string.exercise_barbell_curls_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=kwG2ipFRgfo",
            targetMuscle = Muscle.BICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "hammer_curls",
            nameResId = R.string.exercise_hammer_curls,
            descriptionResId = R.string.exercise_hammer_curls_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=zC3nLlEvin4",
            targetMuscle = Muscle.BICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "incline_curls",
            nameResId = R.string.exercise_incline_curls,
            descriptionResId = R.string.exercise_incline_curls_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=soxrZlIl35U",
            targetMuscle = Muscle.BICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "preacher_curls",
            nameResId = R.string.exercise_preacher_curls,
            descriptionResId = R.string.exercise_preacher_curls_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=fIWP-FRFNU0",
            targetMuscle = Muscle.BICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "concentration_curls",
            nameResId = R.string.exercise_concentration_curls,
            descriptionResId = R.string.exercise_concentration_curls_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=0AZlSIKR90M",
            targetMuscle = Muscle.BICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 45
        )
    )

    val tricepsExercises = listOf(
        Exercise(
            id = "tricep_pushdown",
            nameResId = R.string.exercise_tricep_pushdown,
            descriptionResId = R.string.exercise_tricep_pushdown_desc,
            imageResId = R.drawable.tricepspushdowns,
            gifResId = R.drawable.tricepspushdowns,
            youtubeLink = "https://www.youtube.com/watch?v=2-LAMcpzODU",
            targetMuscle = Muscle.TRICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "skull_crushers",
            nameResId = R.string.exercise_skull_crushers,
            descriptionResId = R.string.exercise_skull_crushers_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=d_KZxkY_0cM",
            targetMuscle = Muscle.TRICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "overhead_extension",
            nameResId = R.string.exercise_overhead_extension,
            descriptionResId = R.string.exercise_overhead_extension_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=_gsUck-7M74",
            targetMuscle = Muscle.TRICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        ),
        Exercise(
            id = "diamond_pushups",
            nameResId = R.string.exercise_diamond_pushups,
            descriptionResId = R.string.exercise_diamond_pushups_desc,
            imageResId = R.drawable.diamondpushups,
            gifResId = R.drawable.diamondpushups,
            youtubeLink = "https://www.youtube.com/watch?v=J0DnG1_S92I",
            targetMuscle = Muscle.TRICEPS,
            sets = 3,
            reps = "Until failure",
            restSeconds = 60
        ),
        Exercise(
            id = "tricep_dips",
            nameResId = R.string.exercise_tricep_dips,
            descriptionResId = R.string.exercise_tricep_dips_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=2z8JmcrW-As",
            targetMuscle = Muscle.TRICEPS,
            sets = 3,
            reps = "12-15",
            restSeconds = 60
        )
    )

    val legsExercises = listOf(
        Exercise(
            id = "squats",
            nameResId = R.string.exercise_squats,
            descriptionResId = R.string.exercise_squats_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=ultWZbUMPL8",
            targetMuscle = Muscle.LEGS,
            sets = 4,
            reps = "8-12",
            restSeconds = 120
        ),
        Exercise(
            id = "deadlifts",
            nameResId = R.string.exercise_deadlifts,
            descriptionResId = R.string.exercise_deadlifts_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=r4MzxtBKyNE",
            targetMuscle = Muscle.LEGS,
            sets = 4,
            reps = "8-12",
            restSeconds = 120
        ),
        Exercise(
            id = "leg_press",
            nameResId = R.string.exercise_leg_press,
            descriptionResId = R.string.exercise_leg_press_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=IZxyjW7MPJQ",
            targetMuscle = Muscle.LEGS,
            sets = 3,
            reps = "12-15",
            restSeconds = 90
        ),
        Exercise(
            id = "lunges",
            nameResId = R.string.exercise_lunges,
            descriptionResId = R.string.exercise_lunges_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=QOVaHwm-Q6U",
            targetMuscle = Muscle.LEGS,
            sets = 3,
            reps = "12 each leg",
            restSeconds = 60
        ),
        Exercise(
            id = "calf_raises",
            nameResId = R.string.exercise_calf_raises,
            descriptionResId = R.string.exercise_calf_raises_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=gwLzBJYoWlI",
            targetMuscle = Muscle.LEGS,
            sets = 4,
            reps = "15-20",
            restSeconds = 45
        )
    )

    val absExercises = listOf(
        Exercise(
            id = "crunches",
            nameResId = R.string.exercise_crunches,
            descriptionResId = R.string.exercise_crunches_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=Xyd_fa5zoEU",
            targetMuscle = Muscle.ABS,
            sets = 3,
            reps = "15-20",
            restSeconds = 45
        ),
        Exercise(
            id = "plank",
            nameResId = R.string.exercise_plank,
            descriptionResId = R.string.exercise_plank_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=pSHjTRCQxIw",
            targetMuscle = Muscle.ABS,
            sets = 3,
            reps = "30-60 sec",
            restSeconds = 45
        ),
        Exercise(
            id = "leg_raises",
            nameResId = R.string.exercise_leg_raises,
            descriptionResId = R.string.exercise_leg_raises_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=l4kQd9eWclE",
            targetMuscle = Muscle.ABS,
            sets = 3,
            reps = "12-15",
            restSeconds = 45
        ),
        Exercise(
            id = "russian_twists",
            nameResId = R.string.exercise_russian_twists,
            descriptionResId = R.string.exercise_russian_twists_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=wkD8rjkodUI",
            targetMuscle = Muscle.ABS,
            sets = 3,
            reps = "20 each side",
            restSeconds = 45
        ),
        Exercise(
            id = "mountain_climbers",
            nameResId = R.string.exercise_mountain_climbers,
            descriptionResId = R.string.exercise_mountain_climbers_desc,
            imageResId = R.drawable.ic_training,
            gifResId = R.drawable.ic_training,
            youtubeLink = "https://www.youtube.com/watch?v=nmwgirgXLYM",
            targetMuscle = Muscle.ABS,
            sets = 3,
            reps = "30 seconds",
            restSeconds = 30
        )
    )

    fun getExercisesForMuscle(muscle: Muscle): List<Exercise> {
        return when (muscle) {
            Muscle.CHEST -> chestExercises
            Muscle.BACK -> backExercises
            Muscle.SHOULDERS -> shoulderExercises
            Muscle.BICEPS -> bicepsExercises
            Muscle.TRICEPS -> tricepsExercises
            Muscle.LEGS -> legsExercises
            Muscle.ABS -> absExercises
            Muscle.NONE -> emptyList()
        }
    }

    val programs = listOf(
        Program(
            id = "beginner_program",
            nameResId = R.string.program_beginner,
            imageResId = R.drawable.trainingprogram1,
            durationWeeks = 8,
            splits = listOf(
                Split(
                    id = "day1",
                    dayNumber = 1,
                    durationMinutes = 45,
                    targetedMuscles = listOf(Muscle.CHEST, Muscle.TRICEPS),
                    exercises = listOf(chestExercises[0], chestExercises[3], tricepsExercises[0], tricepsExercises[3])
                ),
                Split(
                    id = "day2",
                    dayNumber = 2,
                    durationMinutes = 45,
                    targetedMuscles = listOf(Muscle.BACK, Muscle.BICEPS),
                    exercises = listOf(backExercises[0], backExercises[2], bicepsExercises[0], bicepsExercises[1])
                ),
                Split(
                    id = "day3",
                    dayNumber = 3,
                    isRest = true
                ),
                Split(
                    id = "day4",
                    dayNumber = 4,
                    durationMinutes = 45,
                    targetedMuscles = listOf(Muscle.LEGS, Muscle.ABS),
                    exercises = listOf(legsExercises[0], legsExercises[2], absExercises[0], absExercises[1])
                ),
                Split(
                    id = "day5",
                    dayNumber = 5,
                    durationMinutes = 45,
                    targetedMuscles = listOf(Muscle.SHOULDERS, Muscle.ABS),
                    exercises = listOf(shoulderExercises[0], shoulderExercises[1], absExercises[2], absExercises[3])
                )
            )
        ),
        Program(
            id = "intermediate_program",
            nameResId = R.string.program_intermediate,
            imageResId = R.drawable.trainingprogram2,
            durationWeeks = 12,
            splits = listOf(
                Split(
                    id = "day1",
                    dayNumber = 1,
                    durationMinutes = 60,
                    targetedMuscles = listOf(Muscle.CHEST, Muscle.TRICEPS),
                    exercises = listOf(
                        chestExercises[0], chestExercises[1], chestExercises[2],
                        tricepsExercises[0], tricepsExercises[1], tricepsExercises[2]
                    )
                ),
                Split(
                    id = "day2",
                    dayNumber = 2,
                    durationMinutes = 60,
                    targetedMuscles = listOf(Muscle.BACK, Muscle.BICEPS),
                    exercises = listOf(
                        backExercises[0], backExercises[1], backExercises[2],
                        bicepsExercises[0], bicepsExercises[1], bicepsExercises[2]
                    )
                ),
                Split(
                    id = "day3",
                    dayNumber = 3,
                    durationMinutes = 60,
                    targetedMuscles = listOf(Muscle.LEGS),
                    exercises = listOf(
                        legsExercises[0], legsExercises[1], legsExercises[2],
                        legsExercises[3], legsExercises[4]
                    )
                ),
                Split(
                    id = "day4",
                    dayNumber = 4,
                    isRest = true
                ),
                Split(
                    id = "day5",
                    dayNumber = 5,
                    durationMinutes = 60,
                    targetedMuscles = listOf(Muscle.SHOULDERS, Muscle.ABS),
                    exercises = listOf(
                        shoulderExercises[0], shoulderExercises[1], shoulderExercises[2],
                        absExercises[0], absExercises[1], absExercises[2]
                    )
                )
            )
        ),
        Program(
            id = "advanced_program",
            nameResId = R.string.program_advanced,
            imageResId = R.drawable.trainingprogram3,
            durationWeeks = 16,
            splits = listOf(
                Split(
                    id = "day1",
                    dayNumber = 1,
                    durationMinutes = 75,
                    targetedMuscles = listOf(Muscle.CHEST, Muscle.TRICEPS),
                    exercises = chestExercises + tricepsExercises.take(3)
                ),
                Split(
                    id = "day2",
                    dayNumber = 2,
                    durationMinutes = 75,
                    targetedMuscles = listOf(Muscle.BACK, Muscle.BICEPS),
                    exercises = backExercises + bicepsExercises.take(3)
                ),
                Split(
                    id = "day3",
                    dayNumber = 3,
                    durationMinutes = 75,
                    targetedMuscles = listOf(Muscle.LEGS),
                    exercises = legsExercises
                ),
                Split(
                    id = "day4",
                    dayNumber = 4,
                    isRest = true
                ),
                Split(
                    id = "day5",
                    dayNumber = 5,
                    durationMinutes = 75,
                    targetedMuscles = listOf(Muscle.SHOULDERS),
                    exercises = shoulderExercises
                ),
                Split(
                    id = "day6",
                    dayNumber = 6,
                    durationMinutes = 45,
                    targetedMuscles = listOf(Muscle.ABS),
                    exercises = absExercises
                )
            )
        )
    )

    fun getMuscleImageResource(muscles: List<Muscle>): Int {
        return when {
            muscles.containsAll(listOf(Muscle.CHEST, Muscle.TRICEPS)) -> R.drawable.chestandtricepc__2_
            muscles.containsAll(listOf(Muscle.BACK, Muscle.BICEPS)) -> R.drawable.biceps
            muscles.containsAll(listOf(Muscle.LEGS)) -> R.drawable.legs
            muscles.containsAll(listOf(Muscle.SHOULDERS)) -> R.drawable.chest
            muscles.containsAll(listOf(Muscle.ABS)) -> R.drawable.abs
            else -> R.drawable.chest
        }
    }
} 