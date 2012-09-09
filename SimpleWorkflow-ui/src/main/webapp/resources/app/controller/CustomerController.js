Ext.define('Ins.controller.CustomerController', {
	extend : 'Ext.app.Controller',
	stores: ['Customers', 'Addresses'],
	models: ['Customer', 'Address'],
	views : ['CustomerForm', 'CustomerList'],
    refs: [{
        ref: 'custForm', 
        selector: 'form'
    },{
        ref: 'custGrid', 
        selector: 'grid'
    },
    {
    	ref: 'addessGrid',
    	selector: 'form > #addressList'
    }], 

	init : function() {
    	this.control({
            'grid' : {
            	renderer : this.onLoadStore
            },
    		'grid button[id=btnInsert]' : {
            	click : this.onAddCustomer
            },
            'grid button[id=btnEdit]' : {
            	click : this.onEditCustomer
            },
            'grid button[id=btnDelete]' : {
            	click : this.onRemoveCustomer
            },
            'window button[id=btnOk]' : {
            	click : this.onCustomerSubmit
            },
            'window button[id=btnCancel]' : {
            	click : this.onCustomerCancel
            },
            'form button[itemId=addAddress]' : {
            	click : this.onAddAddress
            },
            'form button[itemId=deleteAddress]' : {
            	click : this.onRemoveAddress
            }
        });
    },
    
	onLoadStore : function() {
		this.getCustGrid().getStore().load();
	},
	
    onAddAddress: function(button){
	    console.log('Called Add function');
	    var grid = button.up('grid');
	    console.log(grid.plugins[0]);
	    var rowEditing = grid.plugins[0];
	    rowEditing.cancelEdit();
	    var r = Ext.create('Ins.model.Address', {
	    	addressType: '',
	    	addrStreet: '',
	    	addrStreetExt: '',
	    	city: '',
	    	state: '',
	    	country: '',
	    	postalCode: '',
	    	primary: ''
	    });
	    grid.getStore().insert(0, r);
        rowEditing.startEdit(0, 0);
	},

    onRemoveAddress: function(button){
	    console.log('Called Delete function');
	    var grid = button.up('grid');
	    console.log(grid.plugins[0]);
	    var sm = grid.getSelectionModel();
	    var store = grid.getStore();
	    store.remove(sm.getSelection());
	    if (store.getCount() > 0) {
            sm.select(0);
        }
	},    

    onCustomerSubmit: function(button, e, options) {
    	console.log('Called Customer Submit');
		var win = button.up('window'), form = win.down('form');
		if(form.getForm().isValid()) {
			console.log('Form is valid');
			var arecord = [];
			var agrid = form.down('grid');
			agrid.getStore().each(function(rec) {
	        	arecord.push(rec.data);
	        });
			form.getForm().setValues({addresses_id: Ext.JSON.encode(arecord)});
			if(form.getForm().getValues().idProperty) {
				var operation = 1;
			}
			form.getForm().submit({
        		method: 'POST',
        		url: '/SimpleWorkflow/flow/customer/add',
        		scope: this,
        		failure: function(form, action) {
				    Ext.MessageBox.alert('Error Message', action.result.errorInfo);
				},
				success: function(form, action) {
				    Ext.MessageBox.alert('Confirm', action.result.customer.idProperty);
				    if(operation != 1)
				    this.getCustGrid().getStore().insert(0, action.result.customer);
				    win.close();
				}
	        });
    	}
    },

    onCustomerCancel: function(button, e, options) {
    	console.log('Called Customer Cancel');
		var win = button.up('window');
		win.close();
    },

    onAddCustomer: function(button, e, options) {
    	console.log('Called Add Customer');
		var newCustWin = Ext.create('Ins.view.CustomerForm');
		newCustWin.show();
    },
    
    showCustomerForm: function() {
    	var view = Ext.ClassManager.instantiate('widget.customerform', { width: 800, height: 560});
    	var form = view.down('form');
		form.getForm().setValues({personType: 'C'});
    	view.show();
    },

    showAgentForm: function() {
    	var view = Ext.ClassManager.instantiate('widget.customerform', { width: 800, height: 560});
    	var form = view.down('form');
		form.getForm().setValues({personType: 'A'});
    	view.show();
    },
    
    onEditCustomer: function(button, e, options) {
    	console.log('Called Edit Customer');
        var grid = button.up('gridpanel');
        var customer =  grid.getSelectionModel().getSelection()[0];
        if(customer) {
        	console.log(customer);
        	console.log(customer.addresses());
    		var newCustWin = Ext.create('Ins.view.CustomerForm'), form = newCustWin.down('form');
        	newCustWin.title = 'Edit Customer Form - ' + customer.get('firstName') +',' + customer.get('lastName');

    		var agrid = form.down('grid');
    		agrid.getStore().load({
				  params:{
					  customerId: customer.getId()
		        	 }
		        });
//    		customer.addresses().each(function(rec) {
//    			console.log(rec.data);
//    			console.log(rec.get('addressType'));
//    		});
//    		
//    		agrid.getStore().loadRecords(customer.addresses().getRange(0,customer.addresses().getCount()));
//    		agrid.reconfigure(customer.addresses());
//        	customer.addresses().each(function(address) {
//        		console.log(address.getId());
//        	    var r = Ext.create('Ins.model.Address', {
//        	    	addressType: address.get('addressType'),
//        	    	addrStreet: address.get('addrStreet'),
//        	    	addrStreetExt: address.get('addrStreetExt'),
//        	    	city: address.get('city'),
//        	    	state: address.get('state'),
//        	    	country: address.get('country'),
//        	    	postalCode: address.get('postalCode'),
//        	    	primary: address.get('primary'),
//        	    	id: address.getId()
//        	    });
//        	    console.log(r);
//        		agrid.getStore().add(r);
//        	});
//        	agrid.getStore().loadRecords(customer.addresses());
    		newCustWin.show();
    		form.getForm().loadRecord(customer, {
    			success: function() {
    				console.log("Load successful: ");
    	        	customer.addresses().each(function(address) {
    	        		console.log(address.getId());
    	        	});
    			}
    		});
        }
        else {
        	console.log('Select Customer');
        }
    },
    
    onRemoveCustomer: function(button, e, options) {
    	console.log('Called Delete Customer');
        Ext.Msg.show({
            title:'Delete record?',
            msg: 'Please confirm',
            buttons: Ext.Msg.YESNO,
            icon: Ext.Msg.QUESTION,
            fn: function(btn, text) {
                if(btn == 'yes') {
                    var grid = button.up('gridpanel');
                    var customer =  grid.getSelectionModel().getSelection()[0];
                    var store = grid.getStore();
                    store.remove(customer);
                    store.sync();
                }
            },
            scope: this
        });
   	
    }
});