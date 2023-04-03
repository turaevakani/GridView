package com.geektech.gridview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.gridview.UnselectFragment.Companion.unselectedFragSelectedFragImage
import com.geektech.gridview.databinding.FragmentSelectedBinding


class SelectedFragment : Fragment() {
    lateinit var binding: FragmentSelectedBinding
    private val itemGV = arrayListOf<GridViewModal>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedPhotos = arguments?.getSerializable(unselectedFragSelectedFragImage) as? ArrayList<GridViewModal>
        if (selectedPhotos.isNullOrEmpty()) {
            binding.recyclerView.visibility = View.GONE
        } else {
            itemGV.addAll(selectedPhotos)
            val adapter = SelectedAdapter(itemGV)
            binding.recyclerView.apply {
                layoutManager = GridLayoutManager(context, 3)
                this.adapter = adapter
            }
        }
    }


}