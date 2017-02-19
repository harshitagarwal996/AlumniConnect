package com.example.shivanshu.alumniconnect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shivanshu.alumniconnect.CompanyNameFragment.OnCompanyNameFragmentInteractionListener;
import com.example.shivanshu.alumniconnect.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnCompanyNameFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyCompanyNameRecyclerViewAdapter extends RecyclerView.Adapter<MyCompanyNameRecyclerViewAdapter.ViewHolder> {

    private final String[] strings={"1\tIncise Infotech Pvt. Ltd.\t1st Sept. 2014\n" ,
            "2\tI -Guardian\t7th Sept. 2014\n" ,
            "3\tJaro Education\t11th Sept. 2014\n" ,
            "4\tTATA Consultancy Services\t18th - 20th Sept. 2014\n" ,
            "5\tDaffodil Software Ltd.\t20th Sept. 2014\n" ,
            "6\tOptimus Information, Inc.\t23rd Sept. 2014\n" ,
            "7\tQA Infotech Pvt. Ltd.\t24th Sept. 2014\n" ,
            "8\tNucleus Software Export Ltd.\t25th Sept. 2014\n" ,
            "9\tMiracle Technologies\t26th Sept. 2014\n" ,
            "10\tWOXA TECHNOLOGIES PVT. LTD.\t27th Sept. 2014\n" ,
            "11\tIntelligrape Software Pvt. Ltd.\t29th Sept. 2014\n" ,
            "12\tSap Labs India Pvt. Ltd.\t1st Oct. 2014\n" ,
            "13\tHewlett-Packard India Sales Pvt. Ltd.\t6th Oct. 2014\n" ,
            "14\tVirtusa, Inc.\t6th Oct. 2014\n" ,
            "15\tNIIT Technologies Ltd.\t7th Oct. 2014\n" ,
            "16\tJosh Technologies Ltd.\t9th Oct. 2014\n" ,
            "17\tVelocis Systems Pvt. Ltd.\t9th-10th Oct. 2014\n" ,
            "18\tStratbeans Consulting Pvt. Ltd.\t11th Oct. 2014\n" ,
            "19\tOptimus Information, Inc.\t14th Oct. 2014\n" ,
            "20\tLakshya Technology Solutions Pvt. Ltd.\t15th Oct. 2014\n" ,
            "21\tAsahi Glass India Pvt. Ltd.\t15th Oct. 2014\n" ,
            "22\tSopra Group\t16th Oct. 2014\n" ,
            "23\tL & T Infotech\t16th Oct. 2014\n" ,
            "24\tE-smart Systems PVT. LTD.\t17th Oct. 2014\n" ,
            "25\tMobulous\t18th Oct. 2014\n" ,
            "26\tAllumez Info Tech/\u200B \u200BZilaxy Electronics\t18th Oct. 2014\n" ,
            "27\tApagen Solutions Pvt. Ltd.\t20th Oct. 2014\n" ,
            "28\tAppzCloud Technologies\t30th Oct. 2014\n" ,
            "29\tAsahi Glass India Pvt. Ltd.\t30th Oct. 2014\n" ,
            "30\tCraterZone\t2nd Nov. 2014\n" ,
            "31\tI3India\t5th Nov. 2014\n" ,
            "32\tMphasis (An HP Company)\t6th Nov. 2014\n" ,
            "33\tOpen Text\t7th Nov. 2014\n" ,
            "34\tMindTree Ltd.\t7th-8th Nov. 2014\n" ,
            "35\tTechAhead Corp, Noida\t9th Nov. 2014\n" ,
            "36\tIBM India Pvt. Ltd.\t11-12th Nov. 2014\n" ,
            "37\tJeevansathi.Com\t12th Nov. 2014\n" ,
            "38\t99Acres.Com\t12th Nov. 2014\n" ,
            "39\tWay2Capital\t12th Nov. 2014\n" ,
            "40\tMark IV Systems\t13th Nov. 2014\n" ,
            "41\tEarth Infrastructure Ltd.\t13th & 14th Nov. 2014\n" ,
            "42\tWOXA TECHNOLOGIES PVT. LTD.\t14th Nov. 2014\n" ,
            "43\tMphasis (An HP Company)\t18th & 19th Nov. 2014\n" ,
            "44\tRicha Industries Pvt. Ltd.\t21st & 22nd Nov. 2014\n" ,
            "45\tMobiloitte Technologies Pvt. Ltd.\t24th Nov. 2014\n" ,
            "46\tR System International Ltd.\t25th Nov. 2014\n" ,
            "47\tRetailOn.Net\t25th Nov. 2014\n" ,
            "48\tIndiaMart InterMesh Ltd.\t26th Nov. 2014\n" ,
            "49\tNEC Technologies Ltd.\t28th Nov. 2014\n" ,
            "50\tAON Hewitt\t29th Nov. 2014\n" ,
            "51\tCapgemini Ltd.\t29th Nov. 2014\n" ,
            "52\tLinchpin Technologies\t1st Dec. 2014\n" ,
            "53\tSteria India Pvt. Ltd.\t3rd Dec. 2014\n" ,
            "54\tAgile Softtech Pvt. Ltd.\t3rd Dec. 2014\n" ,
            "55\tInfoEdge India Ltd.\t4th Dec. 2014\n" ,
            "56\tICICI PRUDENTIAL LIFE INSURANCE CO. LTD.\t5th Dec. 2014\n" ,
            "57\tWebkul Software\t6th Dec. 2014\n" ,
            "58\tTransWeb Educational Services Pvt. Ltd.\t6th Dec. 2014\n" ,
            "59\tOptimus Information, Inc.\t6th Dec. 2014\n" ,
            "60\tHomezworld\t8th Dec. 2014\n" ,
            "61\tSanmar Engg. Tech. Ltd.\t9th Dec. 2014\n" ,
            "62\tWipro Global Infrastructure Outsourcing Services\t10th Dec. 2014\n" ,
            "63\tDigital Thomson\t12th Dec. 2014\n" ,
            "64\tNaukri.Com\t12th Dec. 2014\n" ,
            "65\tADVANCED AUTO ACCESSORIES CORP.\t13th Dec. 2014\n" ,
            "66\tAlleTechnolologies\t16th Dec. 2014\n" ,
            "67\tDrishti Soft Technologies\t19th Dec. 2014\n" ,
            "68\tJellyfish Technologies\t19th Dec. 2014\n" ,
            "69\tGoodthrough Software Solution Pvt. Ltd.\t20th Dec. 2014\n" ,
            "70\tAptara Corp\t6th Jan. 2015\n" ,
            "71\tPolicy Bazar\t6th Jan. 2015\n" ,
            "72\tJellyfish Technologies\t7th Jan. 2015\n" ,
            "73\tNucleus Software Export Ltd.\t9th Jan. 2015\n" ,
            "74\tNextGen Invent Corporation\t10th Jan. 2015\n" ,
            "75\tKellton Technologies Pvt. Ltd.\t10th Jan. 2015\n" ,
            "76\tQuantum Pages Pvt. Ltd.\t12th Jan. 2015\n" ,
            "77\tPrint - O - Pack\t12th Jan. 2015\n" ,
            "78\tSchneider Electric Infrastructure Ltd.\t13th Jan. 2015\n" ,
            "79\tQuantum Pages Pvt. Ltd.\t13th Jan. 2015\n" ,
            "80\tJellyfish Technologies\t14th Jan. 2015\n" ,
            "81\tAptara Corp\t14th Jan. 2015\n" ,
            "82\tCSC India Pvt. Ltd.\t14th Jan. 2015\n" ,
            "83\tEvision Tech Solution Pvt. Ltd.\t15th Jan. 2015\n" ,
            "84\tInnoEye Technologies\t16th Jan. 2015\n" ,
            "85\tCodegenesis Solutions\t17th Jan. 2015\n" ,
            "86\tWipro Global Infrastructure Outsourcing Services\t17th Jan. 2015\n" ,
            "87\tDaffodil Software Ltd.\t18th Jan. 2015\n" ,
            "88\tFranconnect\t19th Jan. 2015\n" ,
            "89\tProgressive Infotech Pvt. Ltd.\t19th Jan. 2015\n" ,
            "90\tAltametrics\t20th Jan. 2015\n" ,
            "91\tHDFC Bank Ltd.\t20th Jan. 2015\n" ,
            "92\tMyra Digital (India) Pvt. Ltd.\t20th Jan. 2015\n" ,
            "93\tBeehive Systems\t20th Jan. 2015\n" ,
            "94\tAptean Technologies\t20th Jan. 2015\n" ,
            "95\tApagen Solutions Pvt. Ltd.\t20th Jan. 2015\n" ,
            "96\tHettich India Pvt. Ltd.\t21st Jan. 2015\n" ,
            "97\tMagic Software Pvt. Ltd.\t21st Jan. 2015\n" ,
            "98\tIREO\t21st Jan. 2015\n" ,
            "99\tSNT Infotech Ltd.\t22nd Jan. 2015\n" ,
            "100\tWildnet Technologies\t22nd Jan. 2015\n" ,
            "101\tKhodiyar Group\t23rd Jan. 2015\n" ,
            "102\tNIIT Technologies Ltd.\t23rd Jan. 2015\n" ,
            "103\tNTT Data\t23rd Jan. 2015\n" ,
            "104\tUday Homz Pvt. Ltd.\t23rd Jan. 2015\n" ,
            "105\tPaytm.com\t23rd Jan. 2015\n" ,
            "106\tFinnoit Technologies Pvt. Ltd.\t24th Jan. 2015\n" ,
            "107\tWebkul Software\t24th Jan. 2015\n" ,
            "108\tAptara Corp\t28th Nov. 2014\n" ,
            "109\tGENPACT\t29th Jan. 2015\n" ,
            "110\tSOURCEKEY INDIA PVT. LTD.\t29th Jan. 2015\n" ,
            "111\tIBM India Pvt. Ltd.\t29th-31st Jan. 2015\n" ,
            "112\tILMP Technologies Pvt. Ltd.\t30th Jan. 2015\n" ,
            "113\tMaintec Technologies\t31st Jan. 2015\n" ,
            "114\tSheela Foams Pvt. Ltd.\t31st Jan. 2015"
};
    //private final List<DummyItem> mValues;
    private final OnCompanyNameFragmentInteractionListener mListener;

    public MyCompanyNameRecyclerViewAdapter(List<DummyItem> items, CompanyNameFragment.OnCompanyNameFragmentInteractionListener listener) {
     //   mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_companyname, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
     //   holder.mItem = mValues.get(position);
       // holder.mIdView.setText(mValues.get(position).id);
        //holder.mContentView.setText(mValues.get(position).content);
        holder.mContentView.setText(strings[position
                ]);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onCompanyNameFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 114;//mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
