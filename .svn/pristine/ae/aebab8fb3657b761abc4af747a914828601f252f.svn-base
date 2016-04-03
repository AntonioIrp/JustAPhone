package com.selfdevel.justaphone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class ContactListActivity extends Activity {

	Context contactListActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		List<ContactBean> contactsList = fetchContacts();
		setContentView(R.layout.contact_list_activity);
		super.onCreate(savedInstanceState);
		contactListActivity = this.getApplicationContext();
		
		ListView contactListView = (ListView) this.findViewById(R.id.listOfContacts);

	
		ListAdapter customAdapter = new ContactListAdapter(
				this.getApplicationContext(), R.layout.contact_list_item, contactsList);
		
		contactListView.setAdapter(customAdapter);
		contactListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
				Toast.makeText(contactListActivity, "sdss", Toast.LENGTH_SHORT).show();
			}
		});
	}


	public List<ContactBean> fetchContacts() {

		String noSanitizedPhoneNumber = null;
		String noSanitizedEmailAddress = null;
		List<ContactBean> contactsList = new ArrayList<ContactBean>();

		Uri CONTENT_URI = ContactsContract.Contacts.CONTENT_URI;
		String _ID = ContactsContract.Contacts._ID;
		String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
		String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

		Uri PhoneCONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
		String Phone_CONTACT_ID = ContactsContract.CommonDataKinds.Phone.CONTACT_ID;
		String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;

		Uri EmailCONTENT_URI = ContactsContract.CommonDataKinds.Email.CONTENT_URI;
		String EmailCONTACT_ID = ContactsContract.CommonDataKinds.Email.CONTACT_ID;
		String DATA = ContactsContract.CommonDataKinds.Email.DATA;

		ContentResolver contentResolver = getContentResolver();
		Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, null);

		// Loop for every contact in the phone
		if (cursor.getCount() > 0) {
			while (cursor.moveToNext()) {
				ContactBean contact = new ContactBean();
				
				String contactId = cursor.getString(cursor.getColumnIndex(_ID));
				String contactName = cursor.getString(cursor.getColumnIndex(DISPLAY_NAME));
				
				contact.setContactName(contactName);
				contact.setContactId(contactId);

				int hasPhoneNumber = Integer.parseInt(cursor.getString(cursor.getColumnIndex(HAS_PHONE_NUMBER)));

				if (hasPhoneNumber > 0) {
//					output.append("\n First Name:" + name);
					// Query and loop for every phone number of the contact
					Cursor phoneCursor = contentResolver.query(PhoneCONTENT_URI, null, Phone_CONTACT_ID + " = ?", new String[] { contactId }, null);
					while (phoneCursor.moveToNext()) {
						noSanitizedPhoneNumber = phoneCursor.getString(phoneCursor.getColumnIndex(NUMBER));
						contact.addContactPhoneNumber(noSanitizedPhoneNumber);
//						output.append("\n Phone number:" + noSanitizedPhoneNumber);
					}

					phoneCursor.close();
					
					// Query and loop for every email of the contact
					Cursor emailCursor = contentResolver.query(EmailCONTENT_URI, null, EmailCONTACT_ID + " = ?", new String[] { contactId }, null);
					while (emailCursor.moveToNext()) {
						noSanitizedEmailAddress = emailCursor.getString(emailCursor.getColumnIndex(DATA));
						contact.addContactEmailAddress(noSanitizedEmailAddress);	
//						output.append("\nEmail:" + email);
					}

					emailCursor.close();
					
					contactsList.add(contact);
				}

//				output.append("\n");
			}
		}
		return contactsList;
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, 0);
	}
}
