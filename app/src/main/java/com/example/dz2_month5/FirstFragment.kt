package com.example.dz2_month5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dz2_month5.databinding.FragmentFirstBinding
import com.example.dz2_month5.remote.LoveModel
import com.example.dz2_month5.remote.LoveService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
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