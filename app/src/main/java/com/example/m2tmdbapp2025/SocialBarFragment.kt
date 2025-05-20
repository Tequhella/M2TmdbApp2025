package com.example.m2tmdbapp2025

import android.graphics.Color
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.m2tmdbapp2025.databinding.FragmentSocialBarBinding

class SocialBarFragment : Fragment() {
    private val LOGTAG = SocialBarFragment::class.simpleName
    private lateinit var binding : FragmentSocialBarBinding
    private var cn : Int? = Color.LTGRAY
    private var cs : Int? = Color.RED

    companion object {
        fun newInstance() = SocialBarFragment()
    }

    //private val viewModel: SocialBarViewModel by viewModels()
    private val viewModel by activityViewModels<SocialBarViewModel>()

    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSocialBarBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cn = context?.getColor(R.color.ic_social_normal)
        cs = context?.getColor(R.color.ic_social_selected)

        requireArguments().getString("sbfc_view_tag")?.let {
            val mapkey = it.toInt()
            //Log.d(LOGTAG, "mapkey=$mapkey")

            // set favorite button
            val isFavorite = viewModel.isFavorite.getOrElse(mapkey,{false})
            binding.favoriteIv.setColorFilter(if (isFavorite) cs!! else cn!!)
            binding.favoriteIv.setOnClickListener {
                viewModel.isFavorite.set(mapkey, !viewModel.isFavorite.getOrElse(mapkey,{false}))
                binding.favoriteIv.setColorFilter(if (viewModel.isFavorite[mapkey] == true) cs!! else cn!! )
            }

            // set like button
            val nblikes = viewModel.nbLikes.getOrElse(mapkey, {0})
            binding.nbLikeTv.setText(nblikes.toString())
            val likeColor =  if (nblikes > 0 ) cs!! else cn!!
            binding.likeIv.setColorFilter(likeColor)
            binding.nbLikeTv.setTextColor(likeColor)

            binding.likeIv.setOnClickListener {
                viewModel.nbLikes.set(mapkey,viewModel.nbLikes.getOrElse(mapkey, {0}) + 1)
                binding.nbLikeTv.setText(viewModel.nbLikes[mapkey].toString())
                binding.likeIv.setColorFilter(cs!!)
                binding.nbLikeTv.setTextColor(cs!!)
            }

            // set share button
            binding.shareIv.setColorFilter(cn!!)
            binding.shareIv.setOnClickListener {
                Log.d(LOGTAG,"shared clicked for id=${mapkey}")
            }
        }
    }
}