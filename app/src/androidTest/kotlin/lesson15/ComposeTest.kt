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

package lesson15

import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Test


@HiltAndroidTest
class ComposeTest : ConfiguredTest() {

    @Test
    fun testToolBar() {
        run {
            MainPage {
                toolbarTitle.assertTextEquals("Now in Android")
            }
        }
    }

    @Test
    fun testMainPageElements(){
        run{
            MainPage {
                toolbarSearchButton.assertIsDisplayed()
                toolbarSettingsButton.assertIsDisplayed()
                doneButton.assertIsDisplayed()
                titleList.assertTextEquals("What are you interested in?")
                subtitleList.assertTextEquals("Updates from topics you follow will appear here. Follow some things to get started.")
            }
        }
    }

    @Test
    fun testSearchPageElements(){
        run{
            MainPage.toolbarSearchButton.perform { performClick() }
            SearchPage{
                Thread.sleep(2000)
                backButton.assertIsDisplayed()
                SearchField.assertIsDisplayed()
            }
        }
    }
}