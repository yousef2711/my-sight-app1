package com.yousef.mysight00.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.yousef.mysight00.R

class GpsAlzheimerFragment : Fragment() {

    private lateinit var areaStatusIcon: ImageView
    private var currentState = State.UNKNOWN

    enum class State {
        UNKNOWN,
        SAFE,
        UNSAFE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_gps_alzheimer, container, false)

        areaStatusIcon = view.findViewById(R.id.ic_area_status)

        areaStatusIcon.setImageResource(R.drawable.ic_unknown)

        areaStatusIcon.setOnClickListener {
            changeAreaState()
        }
        return view
    }

    private fun changeAreaState() {
        when (currentState) {
            State.UNKNOWN -> {
                areaStatusIcon.setImageResource(R.drawable.ic_safe)
                currentState = State.SAFE
            }
            State.SAFE -> {
                areaStatusIcon.setImageResource(R.drawable.ic_unsafe)
                currentState = State.UNSAFE
            }
            State.UNSAFE -> {
                areaStatusIcon.setImageResource(R.drawable.ic_unknown)
                currentState = State.UNKNOWN
            }
        }
    }

    companion object {
        fun newInstance() = GpsAlzheimerFragment()
    }
}
