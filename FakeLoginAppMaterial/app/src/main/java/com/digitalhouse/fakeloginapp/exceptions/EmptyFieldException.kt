package com.digitalhouse.fakeloginapp.exceptions

import android.widget.EditText

class EmptyFieldException(message:String, var fields: ArrayList<Int>): Exception(message){

}