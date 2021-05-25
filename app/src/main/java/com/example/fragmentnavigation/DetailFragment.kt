package com.example.fragmentnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.list_item.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: Product? = null
        val id = arguments?.getInt("ID")
        id?.let {
            product = products.find { it.id == id }
        }

        product?.let{
            with(it){
                product_name.text = name
                product_price.text = getString(R.string.product_price, price)
                product_description.text = shortDescription
                product_full_description.text = longDescription
                product_image.setImageResource(imageId)

                buy.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putInt("ID", this.id)
                    findNavController().navigate(R.id.action_detail_to_checkout, bundle)
                }
            }
        }
    }
}
