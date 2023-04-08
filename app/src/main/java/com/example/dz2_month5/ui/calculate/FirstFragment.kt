package com.example.dz2_month5.ui.calculate

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dz2_month5.Pref
import com.example.dz2_month5.R
import com.example.dz2_month5.viewModel.LoveViewModel
import com.example.dz2_month5.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()
    private lateinit var pref: Pref

    @Inject
    lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!viewModel.isUserSeen()){
            findNavController().navigate(R.id.onBoardFragment)
        }

        pref = Pref(requireContext())
        initListener()
        prefer()

        if (!pref.isUserSeen()) {
            findNavController().navigate(R.id.startFragment)
        }
    }

    private fun prefer() {
        preferences.edit().putBoolean("isShow", true)
    }

    private fun initListener() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).observe(viewLifecycleOwner) {
                    Log.d("ololo", "initListener: $it")
                }
            }
        }
    }
}
//                LoveService().api.getPercentage(
//                    etFirstName.text.toString(),
//                    etSecondName.text.toString()
//                ).enqueue(object : Callback<LoveModel> {
//                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
//                        if (response.isSuccessful) {
//                            Log.d("ololo", "onResponse: ${response.body()}")
//                            findNavController().navigate(
//                                R.id.secondFragment,
//                                bundleOf("result" to response.body())
//                            )
//                            etFirstName.text.clear()
//                            etSecondName.text.clear()
//                        }
//                    }
//
//                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
//                        Log.d("ololo", "onResponse: ${t.message}")
//                    }
//
//                })
