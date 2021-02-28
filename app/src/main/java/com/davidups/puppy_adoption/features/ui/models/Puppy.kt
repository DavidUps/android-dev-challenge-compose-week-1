/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.davidups.puppy_adoption.features.ui.models

import java.io.Serializable

data class Puppy(
    val name: String,
    val photo: String,
    val gender: Gender,
    val age: Int
) : Serializable {

    companion object {
        enum class Gender {
            FEMALE,
            MALE
        }

        fun generate() = listOf(
            Puppy(
                "Kay",
                "https://random.dog/027eef85-ccc1-4a66-8967-5d74f34c8bb4.jpg",
                gender = Gender.MALE,
                age = 2,
            ),
            Puppy(
                "Trufa",
                "https://random.dog/0356c15a-8874-4af3-a02a-ed0ae8d62b55.jpg",
                gender = Gender.FEMALE,
                age = 3,
            ),
            Puppy(
                "Curro",
                "https://random.dog/0508da24-5cbb-487c-815d-9c555e244c21.jpg",
                gender = Gender.MALE,
                age = 9,
            ),
            Puppy(
                "Kira",
                "https://random.dog/05f4b372-d8ff-42f0-8c11-b78c45d9eaa1.jpg",
                gender = Gender.FEMALE,
                age = 5,
            ),
            Puppy(
                "Mon",
                "https://random.dog/1032609c-faec-4eb2-9edc-b580fce636f9.jpg",
                gender = Gender.MALE,
                age = 10,
            ),
            Puppy(
                "Chispas",
                "https://random.dog/068fc183-d4e3-4780-b01c-6cce0d019d13.jpg",
                gender = Gender.FEMALE,
                age = 3,
            ),
        )
    }
}
