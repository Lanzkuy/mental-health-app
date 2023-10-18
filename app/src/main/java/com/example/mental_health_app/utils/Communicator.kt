package com.example.mental_health_app.utils

import android.os.Bundle
import androidx.fragment.app.Fragment

interface Communicator{
    fun sendData(bundle: Bundle, fragment: Fragment, tag: String)
}