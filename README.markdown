#Bliss Forms Framework

Helper activity to simplify the creation and validation of forms.

##Example usage

	class WelcomeFormActivity extends FormActivity {

		@Override
		public void onCreate(Bundle savedInstance){
			super.onCreate(savedInstance);
			setContentView(R.layouts.welcome_layout);
		}
		
		//Here's the magic!
		@Override
		protected void inititalizeFormFields(){
		  //TODO fill this up!
		}
	}

Magic.