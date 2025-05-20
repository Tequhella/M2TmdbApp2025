package com.example.m2tmdbapp2025

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.m2tmdbapp2025.databinding.FragmentSocialBarBinding

class SocialBarFragment : Fragment() {
    private val LOGTAG = SocialBarFragment::class.simpleName
    private lateinit var binding : FragmentSocialBarBinding

    companion object {
        fun newInstance() = SocialBarFragment()
    }

    private val viewModel: SocialBarViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSocialBarBinding.inflate(inflater)
        return binding.root
    }
}