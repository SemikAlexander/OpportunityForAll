package com.example.opportunityforall

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.*
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialog
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

inline fun <reified A : Activity> Context.startActivity(configIntent: Intent.() -> Unit = {}) {
    startActivity(Intent(this, A::class.java).apply(configIntent))
}

inline fun <reified A : Activity> Fragment.startActivity(configIntent: Intent.() -> Unit = {}) {
    startActivity(Intent(requireContext(), A::class.java).apply(configIntent))
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

fun Context.toast(@StringRes messageId: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, messageId, duration).show()

fun Fragment.toast(message: String, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(activity, message, duration).show()

fun Fragment.toast(@StringRes messageId: Int, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(activity, messageId, duration).show()

fun phoneNumberMask(editText: EditText) {
    val slots = UnderscoreDigitSlotsParser().parseSlots("+1 ___ ___ ___")
    val formatWatcher: FormatWatcher =
        MaskFormatWatcher( // форматировать текст будет вот он
            MaskImpl.createTerminated(slots)
        )
    formatWatcher.installOn(editText)
}

fun zipCodeMask(editText: EditText) {
    val slots = UnderscoreDigitSlotsParser().parseSlots("_____-____")
    val formatWatcher: FormatWatcher =
        MaskFormatWatcher( // форматировать текст будет вот он
            MaskImpl.createTerminated(slots)
        )
    formatWatcher.installOn(editText)
}

fun showBottomSheetDialog(
    context: Context,
    view: View,
    editText: EditText,
    data: List<String>
) {
    val dialog = BottomSheetDialog(context)
    var sport = ""

    val btnClose = view.findViewById<TextView>(R.id.done)
    val btnNext = view.findViewById<ImageView>(R.id.next)
    val btnPrevious = view.findViewById<ImageView>(R.id.previous)

    val picker = view.findViewById<NumberPicker>(R.id.picker)

    btnClose.setOnClickListener {
        dialog.dismiss()
    }

    picker.minValue = 0
    picker.maxValue = data.size - 1
    picker.wrapSelectorWheel = false
    picker.displayedValues = data.toTypedArray()

    picker.setOnValueChangedListener { _, _, newVal ->
        sport = data[newVal]
    }

    btnClose.setOnClickListener {
        editText.setText(sport)
        dialog.dismiss()
    }

    btnNext.setOnClickListener {

    }

    btnPrevious.setOnClickListener {

    }

    dialog.setCancelable(false)
    dialog.setContentView(view)
    dialog.show()
}