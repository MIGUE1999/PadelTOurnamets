package com.bluetooth.padeltournamets.presentation.view


import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.BottomBarScreen
import com.bluetooth.padeltournamets.presentation.view.ui.composables.scafold.ScaffoldScreen
import com.bluetooth.padeltournamets.presentation.view.ui.composables.screen.Rol
import com.bluetooth.padeltournamets.presentation.view.ui.ui.theme.PadelTOurnametsTheme
import com.bluetooth.padeltournamets.presentation.viewmodel.*
import com.bluetooth.padeltournamets.utilities.session.LoginPref
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONObject

@AndroidEntryPoint
class MainActivity: ComponentActivity(), PaymentResultListener {


    lateinit var navController : NavHostController

    private val searchViewModel: SearchViewModel by viewModels()
    private val tournamentViewModel: TournamentViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()
    private val playerViewModel : PlayerViewModel by viewModels()
    private val organizatorViewModel : OrganizatorViewModel by viewModels()

    lateinit var session: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        session = LoginPref(this)
        if(session.getUserDetails().get(LoginPref.KEY_ROL) == Rol.organizador){
            Log.d("MAINACTIVITY:", "Se hace esto")
            tournamentViewModel.onActualSessionChanged(session)
            val tournamentsByOrgId = tournamentViewModel.getTournametsByOrgId
            tournamentsByOrgId.observe(this){
                Log.d("MainActivity: " ,  "${it.size}")
            }
        }
        Checkout.preload(this@MainActivity)


        setContent {
            PadelTOurnametsTheme {
                // A surface container using the 'background' color from the theme
                /*
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //MyApp1()

                }
                 */
                navController = rememberNavController()
                ScaffoldScreen(navController = navController, searchViewModel , tournamentViewModel,
                    userViewModel, playerViewModel, organizatorViewModel, session )

            }
        }

        /*
        val jugador = JugadorEntity("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865",
        "Miguel Angel", "Tejada")
        val user = UsuarioEntity("migue1990", "prueba", "miguel1999mw@gmail.com", "111111111","203945865")
        val user2 = UsuarioEntity("migue1999", "prueba", "miguel1999mw@gmail.com", "111111111","203945865")
    */
    }



    override fun onPaymentSuccess(p0: String?) {
        navController.navigate(BottomBarScreen.Home.route)
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        navController.navigate(BottomBarScreen.TournamentDetail.route)
    }

}

fun savePayments(amount : Int, activity : Activity ){
    val checkout = Checkout()
    checkout.setKeyID("rzp_test_xpZWqx3vLFKVRg")
    try{
        val options = JSONObject()
        options.put("name", "Razorpay Demo")
        options.put("description", "Pago para la inscripción al torneo")
        //options.put("image", "")
        options.put("theme.color", "#3399cc")
        options.put("currency", "EUR")
        options.put("amount", amount * 100)

        val retryObj = JSONObject()
        retryObj.put("enabled", true)
        retryObj.put("max_count", 4)
        retryObj.put("retry", retryObj)

        checkout.open(activity,options)
    }catch (e : Exception){
        Toast.makeText(activity, "Error en el pago " + e.message, Toast.LENGTH_LONG)
            .show()
        e.printStackTrace()
    }
}
