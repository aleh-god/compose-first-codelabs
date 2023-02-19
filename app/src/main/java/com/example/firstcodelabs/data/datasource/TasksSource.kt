package com.example.firstcodelabs.data.datasource

import com.example.firstcodelabs.domain.models.Task

object TasksSource {

    fun getTasks(number: Int): List<Task> {
        if (number < 1) return emptyList()
        return (1 .. number).map {
            Task(
                id = it,
                date = "$it Feb",
                description = "Task $it description"
            )
        }
    }

    fun getHandMadeTasks(): List<Task> = listOf(
        Task(
            id = 1,
            date = "1 Feb",
            description = "Task 1 description"
        ),
        Task(
            id = 2,
            date = "1 Feb",
            description = "Task 2 description"
        ),
        Task(
            id = 3,
            date = "2 Feb",
            description = "Task 3 description"
        ),
        Task(
            id = 4,
            date = "2 Feb",
            description = "Task 4 description"
        ),
        Task(
            id = 5,
            date = "3 Feb",
            description = "Task 5 description"
        ),
        Task(
            id = 6,
            date = "3 Feb",
            description = "Task 6 description"
        ),
        Task(
            id = 7,
            date = "4 Feb",
            description = "Task 7 description"
        )
    )
}
