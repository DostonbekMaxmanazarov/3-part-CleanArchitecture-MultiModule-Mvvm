package uz.uzapexsoft.cleanarchitecture.presentation.utils.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit

fun FragmentActivity.addFragment(
    @IdRes container: Int, fragment: Fragment, addToBackStack: Boolean = false
) {
    supportFragmentManager.commit {
        add(container, fragment)
        if (addToBackStack) addToBackStack(fragment.javaClass.simpleName)
    }
}

fun Fragment.addFragment(
    @IdRes container: Int, fragment: Fragment, addToBackStack: Boolean = false, args: Bundle? = null
) {
    fragment.arguments = args
    requireActivity().supportFragmentManager.commit {
        add(container, fragment)
        if (addToBackStack)
            addToBackStack(fragment.javaClass.simpleName)
    }
}

fun Fragment.replaceFragment(
    @IdRes container: Int, fragment: Fragment, addToBackStack: Boolean = false, args: Bundle? = null
) {
    fragment.arguments = args
    requireActivity().supportFragmentManager.commit {
        replace(container, fragment)
        if (addToBackStack)
            addToBackStack(fragment.javaClass.simpleName)
    }
}