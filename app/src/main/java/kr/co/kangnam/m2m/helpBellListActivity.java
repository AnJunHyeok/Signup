package kr.co.kangnam.m2m;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by aks56 on 2018-01-29.
 */

public class helpBellListActivity extends AppCompatActivity {
    private String[] titles = {
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자"
    };

    private String[] titles2 = {
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자",
            "샬롬관 6층\n15시 35분 05초 여자"
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.helpbell_list_layout);

        Button backBtn = (Button) findViewById(R.id.backBtn_Helpbell_List);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        CustomAdapter adapter = new CustomAdapter(this);
        ListView list = (ListView)findViewById(R.id.list_Helpbell_Helper);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), helpBellHelperRequestActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        CustomAdapter2 adapter2 = new CustomAdapter2(this);
        ListView list2 = (ListView)findViewById(R.id.list2_Helpbell_Helper);
        list2.setAdapter(adapter2);

    }

    private class CustomAdapter extends ArrayAdapter<String>{
        Context context;

        public CustomAdapter(Context context){
            super(context, R.layout.listitem_layout, titles);
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem_layout, null, true);
            TextView title = (TextView)rowView.findViewById(R.id.text_list);
            title.setText(titles[position]);
            return rowView;
        }
    }

    private class CustomAdapter2 extends ArrayAdapter<String>{
        Context context;

        public CustomAdapter2(Context context){
            super(context, R.layout.listitem2_layout, titles2);
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            View rowView = inflater.inflate(R.layout.listitem2_layout, null, true);
            TextView title = (TextView)rowView.findViewById(R.id.text_list);
            title.setText(titles2[position]);
            return rowView;
        }
    }
}
