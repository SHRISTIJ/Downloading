package com.example.shristi.usert1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class UsersAdapter extends ArrayAdapter<Users> {
    public LayoutInflater mInflater;
    public int mResource;
    public  String link;


    /**
     * Constructor
     *  @param context     The current context.
     * @param resource    The resource ID for a layout file containing a TextView to use when
     *                    instantiating views.
     * @param users The objects to represent in the ListView.
     */
    public UsersAdapter(Context context, int resource, List<Users> users)
    {
        super( context, resource, users );
        mResource = resource;
        mInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getView( int position, View convertView, ViewGroup parent )
    {
        View view = convertView == null ? mInflater.inflate( mResource, parent, false ) : convertView;

        TextView UsersNameView = (TextView) view.findViewById( R.id.UsersName );
       TextView cuisineView = (TextView) view.findViewById( R.id.UsersCuisine );
        TextView DescriptionView = (TextView) view.findViewById( R.id.UsersLocations );

        Users item = getItem( position );

        UsersNameView.setText( item.getName1() );

        DescriptionView.setText(item.getClasses());
        //String locationsNumberTextTemplate = getContext().getResources().getQuantityString( R.plurals.Users_locations, item.getLocations().size() );
        // locationsNumberView.setText( String.format(locationsNumberTextTemplate, item.getLocations().size()) );
        link =item.getLink();
        String g;

       // Scanner sc1=new Scanner(System.in);
        ss o1 =new ss();
        String input="";
        int i=0,p=0;
      //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Enter the string");
        try{input = link;

        }catch(Exception e)
        {
            System.out.println("Check the link and internet connection");
        }
        System.out.println(o1.rev(input));
        g=o1.rev(input);
        String s1="";
        //System.out.println(g);
        while(g.charAt(i)!='/')
        {	if(g.charAt(i)=='g')
        {p=1;}

            if(p==1)
            {	if(g.charAt(i)==' ')
            {s1=s1+"02%";
                i=i+2;
            }

            else
            {s1=s1+g.charAt(i);}
            }
            i++;
        }

      //  System.out.println(o1.rev(s1));
link=o1.rev(s1);
        cuisineView.setText( link );
        return view;
    }
}
