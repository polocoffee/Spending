package com.banklannister.spending.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.banklannister.spending.balance.presentation.BalanceScreenCore
import com.banklannister.spending.core.presentation.ui.theme.SpendingTheme
import com.banklannister.spending.core.presentation.util.Background
import com.banklannister.spending.core.presentation.util.Screen
import com.banklannister.spending.spending_detail.presentation.SpendingDetailScreenCore
import com.banklannister.spending.spending_overview.presentation.SpendingOverviewScreenCore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpendingTheme {
                Navigation()
            }
        }
    }


    @Composable
    fun Navigation(modifier: Modifier = Modifier) {
        val navController = rememberNavController()

        Background()

        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = Screen.SpendingOverview
        ) {

            composable<Screen.SpendingOverview> {
                SpendingOverviewScreenCore(
                    onBalanceClick = {
                        navController.navigate(Screen.Balance)
                    },
                    onAddSpendingClick = {
                        navController.navigate(Screen.SpendingDetail(-1))
                    }
                )
            }

            composable<Screen.SpendingDetail> {
                SpendingDetailScreenCore(
                    onSaveSpending = {
                        navController.popBackStack()
                    }
                )
            }

            composable<Screen.Balance> {
                BalanceScreenCore(
                    onSaveClick = {
                        navController.popBackStack()
                    }
                )
            }

        }
    }

}