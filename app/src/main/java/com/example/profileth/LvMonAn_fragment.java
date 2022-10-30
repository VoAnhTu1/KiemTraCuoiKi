package com.example.profileth;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AlertDialog;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.RecyclerView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DatabaseReference;

        import java.io.Serializable;
        import java.util.ArrayList;

public class LvMonAn_fragment extends Fragment {
    ListView lvMonAn ;
    int vitrixoa=-1;
    ArrayList<Monan> arrayMonAn;
    MonAnAdapter adapter;
    Button btnXoa;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.layout_lvmonan_fragment,container,false);
        lvMonAn = (ListView) view.findViewById(R.id.lv_monAn);
        btnXoa = (Button) view.findViewById(R.id.btnXoa);
        Bundle bd = new Bundle();



        //xoa su kien
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(vitrixoa==-1){
                    Toast.makeText(view.getContext(), "Giữ chọn món ăn muốn xóa trước khi xóa", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    xacNhanXoa(vitrixoa);
                    vitrixoa=-1;
                }

            }
        });

        //long click lv de xoa
        lvMonAn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                vitrixoa = i;
                Toast.makeText(view.getContext(), "Nhấn xóa để xóa món "+arrayMonAn.get(i).getTen(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        //click lv
        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(view.getContext(),ManHinhChiTiet.class);
                Monan monan=  new Monan();

                bd.putInt("anh",arrayMonAn.get(i).getAnh());
                bd.putString("ten",arrayMonAn.get(i).getTen());
                bd.putString("mota",arrayMonAn.get(i).getMota());


                it.putExtra("dulieu",bd);
                startActivity(it);
            }
        });

        arrayMonAn= new ArrayList<>();
        arrayMonAn.add(new Monan("Bún đậu mắm tôm","30k",R.drawable.bundau));
        arrayMonAn.add(new Monan("Tô mì","30k", R.drawable.tomi));
        arrayMonAn.add(new Monan("Chè","20k ",R.drawable.che));
        arrayMonAn.add(new Monan("Bít tết","150k", R.drawable.bittet));
        arrayMonAn.add(new Monan("Lẩu thái","50k",R.drawable.lauthai));
        arrayMonAn.add(new Monan("Heineken","400k", R.drawable.bia));
        arrayMonAn.add(new Monan("Gà rán","50k", R.drawable.garan));
        arrayMonAn.add(new Monan("Chiên trứng ","20k", R.drawable.chientrung));
        adapter = new MonAnAdapter(getContext(), R.layout.dongmonan, arrayMonAn);
        lvMonAn.setAdapter(adapter);
        return view;

    }
    //ham xac nhan xoa
    private void xacNhanXoa(int xoa){
        AlertDialog.Builder alerdialog = new AlertDialog.Builder(getContext());
        alerdialog.setTitle("Thông báo");
        alerdialog.setTitle("Bạn muốn xóa "+arrayMonAn.get(xoa).getTen()+" không!!");
        alerdialog.setPositiveButton("Xác nhận xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "Đã xóa món "+ arrayMonAn.get(xoa).getTen(), Toast.LENGTH_SHORT).show();
                arrayMonAn.remove(xoa);
                adapter.notifyDataSetChanged();

            }
        });
        alerdialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alerdialog.setIcon(R.mipmap.ic_launcher);
        alerdialog.show();

    }



}
