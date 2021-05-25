package com.example.fragmentnavigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_checkout.*


/**
 * A simple [Fragment] subclass.
 */
class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
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
                order_total.text = getString(R.string.order_total, price)
                product_image.setImageResource(imageId)

                checkout.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putInt("ID", this.id)
                    findNavController().navigate(R.id.action_checkout_to_thanks, bundle)
                }
            }
        }
    }
}
