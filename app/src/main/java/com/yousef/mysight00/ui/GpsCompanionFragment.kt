package com.yousef.mysight00.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.yousef.mysight00.R
import com.yousef.mysight00.databinding.FragmentGpsCompanionBinding

class GpsCompanionFragment : Fragment() {

    private var _binding: FragmentGpsCompanionBinding? = null
    private val binding get() = _binding!!
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGpsCompanionBinding.inflate(inflater, container, false)

        binding.unsafeArea.setOnClickListener {
            showWarningPopup()
        }

        return binding.root
    }

    private fun showWarningPopup() {
        binding.securityPopup.visibility = View.VISIBLE
        binding.securityPopup.alpha = 0f
        binding.securityPopup.animate().alpha(1f).setDuration(500).start()

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.alert_sound)
        mediaPlayer.start()

        binding.securityPopup.setOnClickListener {
            binding.securityPopup.visibility = View.GONE
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            mediaPlayer.release()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        if (::mediaPlayer.isInitialized) mediaPlayer.release()
    }
}
