package com.sesootweb.sesootwebapp.sliderSetting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;

import com.sesootweb.sesootwebapp.R;
import com.sesootweb.sesootwebapp.databinding.ItemSliderBinding;
import com.sesootweb.sesootwebapp.sliderSetting.model.SliderItem;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderShowAdapter extends SliderViewAdapter<SliderShowAdapter.SliderHolder> {
    private Context mContext;
    private List<SliderItem> mSliderItems=new ArrayList<>();

    public SliderShowAdapter(Context context) {
        mContext = context;

        mSliderItems.add(new SliderItem("به دنیای هوشمند خدمات دیجیتال سه سوت وب خوش آمدید", R.drawable.ic_se_soot_web_logo));
        mSliderItems.add(new SliderItem("طراحی اپلیکیشن های موبایل و وب ",R.drawable.ic_web));
        mSliderItems.add(new SliderItem("سئو سایت \n کسب رتبه های برتر گوگل فقط با ما",R.drawable.img_seo));
        mSliderItems.add(new SliderItem("طراحی اپلیکیشن\n اپلیکیشن موبایل (اندروید و ios) و اپلیکیشن های تحت سرور ( PWA و WebView و ... )",R.drawable.img_app));
    }

    @Override
    public SliderHolder onCreateViewHolder(ViewGroup parent) {
        ItemSliderBinding binding= DataBindingUtil.
                inflate(LayoutInflater.from(mContext),R.layout.item_slider,parent,false);

        return new SliderHolder(binding);
    }

    @Override
    public void onBindViewHolder(SliderHolder viewHolder, int position) {
            viewHolder.binding(mSliderItems.get(position));
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class SliderHolder extends SliderViewAdapter.ViewHolder{
        private ItemSliderBinding mBinding;

        public SliderHolder(ItemSliderBinding binding) {
            super(binding.getRoot());
            mBinding=binding;
        }

        private void binding(SliderItem sliderItem){
            mBinding.setSliderItem(sliderItem);
        }
    }
}
