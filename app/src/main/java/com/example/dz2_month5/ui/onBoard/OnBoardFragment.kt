package com.example.dz2_month5.ui.onBoard

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.dz2_month5.Pref
import com.example.dz2_month5.R
import com.example.dz2_month5.databinding.FragmentOnBoardBinding
import com.example.dz2_month5.ui.onBoard.anapter.OnBoardingAdapter
import com.example.dz2_month5.viewModel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private val viewModel: LoveViewModel by viewModels()
    @Inject
    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        val adapter = OnBoardingAdapter(){
            pref.saveUserSeen()
            findNavController().navigate(OnBoardFragmentDirections.actionOnBoardFragmentToFirstFragment())
            findNavController().navigate(OnBoardFragmentDirections.actionOnBoardFragmentToFirstFragment())
        }
        binding.viewPager.adapter = adapter
    }
}
