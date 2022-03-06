package com.baharudin.loundryyuk.presentation.common.extention

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import com.baharudin.loundryyuk.R

fun Context.showToast(messege : String) {
    Toast.makeText(this, messege, Toast.LENGTH_SHORT).show()
}
fun Context.showGenericAlertDialog(message: String){
    AlertDialog.Builder(this).apply {
        setMessage(message)
        setPositiveButton(getString(R.string.button_text_ok)){ dialog, _ ->
            dialog.dismiss()
        }
    }.show()
}