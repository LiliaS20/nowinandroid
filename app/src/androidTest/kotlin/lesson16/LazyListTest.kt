/*
 * Copyright 2026 The Android Open Source Project
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

package lesson16

import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.MainScope
import lesson15.ConfiguredTest
import org.junit.Test

@HiltAndroidTest
class LazyListTest: ConfiguredTest() {

    @Test
    fun checkItems() {
        run() {
            step("Проверка элементов в горизонтальном списке") {
                MainScreen.items.childAt<TopicsItem>(0) {
                    image.assertIsDisplayed()
                    title.assertIsDisplayed()
                    plusIcon.assertIsDisplayed()
                }
                MainScreen.items.childAt<TopicsItem>(1) {
                    assertIsDisplayed()
                }
                MainScreen.items.childAt<TopicsItem>(2) {
                    assertIsDisplayed()
                }
            }
            step("Клик по топику") {
                MainScreen.items.childAt<TopicsItem>(2) {
                    plusIcon.performClick()
                    checkedIcon.assertIsDisplayed()
                }
            }
            step("Проверить, что новости отобразились") {
                MainScreen.news.childAt<NewsCard>( 0) {
                    assertIsDisplayed()
                }
            }
        }
    }
}