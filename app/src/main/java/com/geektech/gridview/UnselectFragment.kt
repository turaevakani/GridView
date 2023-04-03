package com.geektech.gridview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.geektech.gridview.databinding.FragmentUnselectBinding


class UnselectFragment : Fragment() {
    lateinit var binding: FragmentUnselectBinding
    lateinit var adapter: UnselectedAdapter
    private val data = arrayListOf<GridViewModal>()
    private val selectedImages = mutableListOf<GridViewModal>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnselectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = UnselectedAdapter(data, this::addImage, this::removeImage)
        binding.apply {
            recyclerview.layoutManager = GridLayoutManager(requireContext(), 3)
            recyclerview.adapter = adapter
        }
        binding.btnSelect.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable(unselectedFragSelectedFragImage, ArrayList(selectedImages))
            }
            data.clear()
            selectedImages.clear()
            findNavController().navigate(R.id.selectedFragment, bundle)
        }
    }

    private fun addImage(itemGV: GridViewModal) {
        selectedImages.add(itemGV)
    }

    private fun removeImage(itemGV: GridViewModal) {
        selectedImages.remove(itemGV)
    }

    private fun loadData() {
        data.add(GridViewModal("https://i.pinimg.com/564x/72/36/a9/7236a90e8ba559f23334285b46d8e304.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/564x/72/36/a9/7236a90e8ba559f23334285b46d8e304.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/564x/72/36/a9/7236a90e8ba559f23334285b46d8e304.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/564x/72/36/a9/7236a90e8ba559f23334285b46d8e304.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/564x/72/36/a9/7236a90e8ba559f23334285b46d8e304.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/originals/74/76/f1/7476f1144b39db3901054768c242612a.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/originals/74/76/f1/7476f1144b39db3901054768c242612a.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/originals/74/76/f1/7476f1144b39db3901054768c242612a.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/originals/74/76/f1/7476f1144b39db3901054768c242612a.jpg", isSelected = false))
        data.add(GridViewModal("https://i.pinimg.com/originals/74/76/f1/7476f1144b39db3901054768c242612a.jpg", isSelected = false))
        data.add(GridViewModal("https://cms.eliza.co.uk/wp-content/uploads/2022/08/SEI_119661720.jpg?w=1024", isSelected = false))
        data.add(GridViewModal("https://cms.eliza.co.uk/wp-content/uploads/2022/08/SEI_119661720.jpg?w=1024", isSelected = false))
        data.add(GridViewModal("https://cms.eliza.co.uk/wp-content/uploads/2022/08/SEI_119661720.jpg?w=1024", isSelected = false))
        data.add(GridViewModal("https://cms.eliza.co.uk/wp-content/uploads/2022/08/SEI_119661720.jpg?w=1024", isSelected = false))
        data.add(GridViewModal("https://cms.eliza.co.uk/wp-content/uploads/2022/08/SEI_119661720.jpg?w=1024", isSelected = false))
    }

    companion object {
        const val unselectedFragSelectedFragImage = "DATA"
    }


}