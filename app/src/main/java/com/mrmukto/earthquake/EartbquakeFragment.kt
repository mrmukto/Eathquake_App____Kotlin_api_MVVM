package com.mrmukto.earthquake

import android.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrmukto.earthquake.Custom.DatePickerFragment
import com.mrmukto.earthquake.adapter.EarthquakeAdapter
import com.mrmukto.earthquake.databinding.FragmentEartbquakeBinding
import com.mrmukto.earthquake.viewmodels.EarthquakeViewModel


class EartbquakeFragment : Fragment() {
    private lateinit var binding: FragmentEartbquakeBinding
    private var from = "1"
    val rectorList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
    private val earthquakeViewModel: EarthquakeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEartbquakeBinding.inflate(inflater,container, false)

        initSpinner()
        binding.fromBtn.setOnClickListener {
            DatePickerFragment{
            }.show(childFragmentManager, null)
        }
        binding.toBtn.setOnClickListener {
            DatePickerFragment{
            }.show(childFragmentManager, null)
        }
        val adapter= EarthquakeAdapter()
        binding.eqlistRV.layoutManager= LinearLayoutManager(requireActivity()).apply {
            orientation = LinearLayoutManager.VERTICAL
        }
        binding.eqlistRV.adapter = adapter
        earthquakeViewModel.fetchData()
        Log.d("ViewModel", "${earthquakeViewModel}")

        earthquakeViewModel.earthquakeLiveData.observe(viewLifecycleOwner) {
            Log.d("TAG", "${it.features.size}")
            adapter.submitList(it.features)

        }
        return binding.root
    }
    private fun initSpinner() {
        val adapter = ArrayAdapter<String>(
            requireActivity(),
            R.layout.simple_spinner_dropdown_item,
            rectorList
        )
        binding.recterSp.adapter = adapter

        binding.recterSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                from = p0?.getItemAtPosition(p2).toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }

}

