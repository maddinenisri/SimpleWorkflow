Ext.define('Ins.view.CustomerForm', {
    extend: 'Ext.window.Window',
    alias: 'widget.customerform',

    autoRender: false,
    height: 560,
    width: 800,
    layout: {
        type: 'fit'
    },
    title: 'Customer properties',
    modal: true,

    initComponent: function() {
        var me = this;
    	var store = Ext.create('Ins.store.Addresses');

        Ext.applyIf(me, {
            dockedItems: [
                {
                    xtype: 'toolbar',
                    ui: 'footer',
                    dock: 'bottom',
                    layout: {
                        pack: 'center'
                    },
                    items: [
                        {
                            xtype: 'button',
                            id: 'btnOk',
                            text: 'Ok',
                            minWidth: 80
                        },
                        {
                            xtype: 'button',
                            id: 'btnCancel',
                            text: 'Cancel',
                            minWidth: 80
                        }
                    ]
                }
            ],
            items: [
                {
                    xtype: 'form',
                    url:'flow/customer/add',
                    method: 'POST',
                    bodyPadding: 10,
                    width: 788,
                    bodyStyle:'padding:5px',
                    fieldDefaults: {
                        labelAlign: 'top',
                        msgTarget: 'side'
                    },
                    defaults: {
                        anchor: '100%'
                    },
                    id: 'customerform',
                    frameHeader: false,
                    preventHeader: true,
                    items: [{
                        layout:'column',
                        border:false,
                        items:[{
                            columnWidth:.5,
                            border:false,
                            layout: 'anchor',
                            defaultType: 'textfield',
                            items: [{
                            	xtype: 'combo',
                            	fieldLabel: 'Salutation',
                                anchor: '95%',
                                msgTarget: 'side',
                                id: 'salutationType',
                                name: 'salutationType',
                        		store: new Ext.data.Store({
                       			fields: ['name', 'desc'],
                        			data: [
                        			   {"name":"Mr", "desc":"Mr"},
                        			   {"name":"Mrs", "desc":"Mrs"},
                        			   {"name":"Miss", "desc":"Miss"},
                        			   {"name":"Ms", "desc":"Ms"},
                        			   {"name":"Dr", "desc":"Dr"}
                        			]
                        		}), // end of Ext.data.SimpleStore
                        		triggerAction:'all', 
                        		displayField: 'desc',
                        		valueField: 'name',	
                        		typeAhead: true,
                        		queryMode: 'local',
                        		queryDelay: 3,
                        		emptyText:'Select a Salutation...',
                        		selectOnFocus:true
                            },
                            {
                                xtype: 'textfield',
                                fieldLabel: 'First Name',
                                anchor: '95%',
                                name: 'firstName',
                                msgTarget: 'side',
                                id: 'firstName'
                            },
                            {
                                xtype: 'textfield',
                                fieldLabel: 'Last Name',
                                anchor: '95%',
                                name: 'lastName',
                                msgTarget: 'side',
                                id: 'lastName'
                            },
                            {
                                xtype: 'textfield',
                                fieldLabel: 'Middle Name',
                                anchor: '95%',
                                name: 'middleName',
                                msgTarget: 'side',
                                id: 'middleName'
                            },
                            {
                                xtype: 'radiogroup',
                                height: 53,
                                id: '',
                                width: 200,
                                layout: {
                                    type: 'vbox'
                                },
                                fieldLabel: 'Gender',
                                allowBlank: false,
                                columns: 2,
                                items: [
                                    {
                                        xtype: 'radiofield',
                                        name: 'genderType',
                                        boxLabel: 'Male',
                                        inputValue: 'M',
                                        flex: 1
                                    },
                                    {
                                        xtype: 'radiofield',
                                        name: 'genderType',
                                        boxLabel: 'Female',
                                        inputValue: 'F',
                                        flex: 1
                                    }
                                ]
                            },{
                                xtype: 'hidden',
                                name: 'idProperty',
                                id: 'idProperty'
                            }]
                        },{
                            columnWidth:.5,
                            border:false,
                            layout: 'anchor',
                            defaultType: 'textfield',
                            items: [{
                                xtype: 'textfield',
                                fieldLabel: 'Email',
                                anchor: '95%',
                                name: 'email',
                                msgTarget: 'side',
                                vtype: 'email',
                                vtypeText: 'Enter Valid Email Address',
                                id: 'email'
                            },
                            {
                                xtype: 'datefield',
                                fieldLabel: 'Date Of Birth',
                                anchor: '95%',
                                name: 'birthDate',
                                format:'Y-m-d',
                                msgTarget: 'side',
                                id: 'birthDate'
                            },
                            {
                            	xtype: 'combo',
                            	fieldLabel: 'Marital Status',
                                anchor: '95%',
                                msgTarget: 'side',
                                id: 'maritalStatusType',
                                name: 'maritalStatusType',
                        		store: new Ext.data.SimpleStore({
                            	fields: ['code','desc'],
                            	data: [
                              		["MARRIED","Married"],["SEPARATED","Separated"],["UNMARRIED", "Un Married"],["WIDOWED","Widowed"]]
                        		}), // end of Ext.data.SimpleStore
                        		displayField: 'desc',
                        		valueField: 'code',	
                        		triggerAction:'all', 
                        		typeAhead: true,
                        		queryMode: 'local',
                        		queryDelay: 3,
                        		emptyText:'Select a Marital Status...',
                        		selectOnFocus:true
                            },
                            {
                                xtype: 'textfield',
                                fieldLabel: 'Income Source',
                                anchor: '95%',
                                name: 'incomeSource',
                                msgTarget: 'side',
                                id: 'incomeSource'
                            },
                            {
                                xtype: 'textfield',
                                fieldLabel: 'Occupation',
                                anchor: '95%',
                                name: 'occupation',
                                msgTarget: 'side',
                                id: 'occupation'
                            },
                            {
                                xtype: 'textfield',
                                fieldLabel: 'Organization',
                                anchor: '95%',
                                name: 'orgName',
                                msgTarget: 'side',
                                id: 'orgName'
                            },{
                                xtype: 'hidden',
                                name: 'addresses',
                                id: 'addresses_id'
                            },{
                                xtype: 'hidden',
                                name: 'personType',
                                id: 'personType'
                            }]
                        }]
                    },{
                        xtype:'tabpanel',
                        plain:true,
                        activeTab: 0,
                        deferredRender: false,
                        layoutOnTabChange: true,
                        height:200,
                        defaults:{bodyStyle:'padding:10px'},
                        items:[{
                            title:'Address Details',
                            xtype: 'gridpanel',
                            itemId:'addressList',
                            store: store,
                            listeners: {
                        	    selectionchange: function(view, records) {
                                    this.down('#deleteAddress').setDisabled(!records.length);
                                }	    
                        	},
                            dockedItems: [{
                    	        xtype: 'toolbar',
                    	        items: [{
                    	            iconCls: 'icon-add',
                    	            itemId: 'addAddress',
                    	            text: 'Add'
                    	        }, {
                    	            iconCls: 'icon-delete',
                    	            text: 'Delete',
                    	            disabled: true,
                    	            itemId: 'deleteAddress'
                    	        }]
                        	}],
                            columns: [
                                {
                                    xtype: 'gridcolumn',
                                    dataIndex: 'id',
                                    text: 'Address ID',
                                    flex: 1,
                        			hidden: true
                                },
                        		{text: 'Address Type', dataIndex: 'addressType', flex: 3, editor: {allowBlank: false}},
                        		{text: 'Addr Street', dataIndex: 'addrStreet', flex: 3,  editor: {allowBlank: false}},
                        		{text: 'Addr Street Ext', dataIndex: 'addrStreetExt', flex: 3, editor: {allowBlank: true}},
                        		{text: 'City', dataIndex: 'city', flex: 3, editor: {allowBlank: false}},
                        		{text: 'State', dataIndex: 'state', flex: 3, editor: {allowBlank: false}},
                        		{text: 'Country', dataIndex: 'country', flex: 3, editor: {allowBlank: false}},
                        		{text: 'Postal Code', dataIndex: 'postalCode', flex: 3, editor: {allowBlank: false}},
                        		{text: 'Primary', dataIndex: 'primary', flex: 3, editor: {xtype: 'checkbox', allowBlank: true, cls: 'x-grid-checkheader-editor'}},
                            ],
                            viewConfig: {

                            },
                        	plugins: [Ext.create('Ext.grid.plugin.RowEditing', {
                                clicksToMoveEditor: 1,
                                autoCancel: false
                            })]
                            },{
                            title:'Phone Numbers',
                            defaultType: 'textfield',
                            hideMode: 'offsets',
                            layoutConfig: {
                            	columns: 2
                            },
                            items: [{
                                border:true,
                                layout: 'anchor',
                                xtype: 'container',
                                layoutConfig: {
                                	columns: 2
                                },
     
                            items: [{
                                layout:'column',
                                border:false,

                            items:[{
                                columnWidth:.5,
                                border:false,
                                layout: 'anchor',
                                defaultType: 'textfield',
                                items: [{
                                	xtype: 'combo',
                                	fieldLabel: 'Primary Phone',
                                    anchor: '95%',
                                    msgTarget: 'side',
                                    id: 'pprimary',
                                    name: 'pprimary',
                            		store: new Ext.data.SimpleStore({
                                	fields: ['code','desc'],
                                	data: [
                                  		["H","Home"],["W","Work"],["C","Cell"],["F","Fax"],["O","Other"]]
                            		}), // end of Ext.data.SimpleStore
                            		displayField: 'desc',
                            		valueField: 'code',	
                             		focusOnToFront: true, 
                             		minChars:1,
                             		queryMode: 'local',
                             		queryDelay: 3,
                            		emptyText:'Select a priamry Phone Type...',
                            		selectOnFocus:true,
                            		selectOnTab: true,
                            		forceSelection: true,
                            		typeAhead:true
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Home',
                                    anchor: '95%',
                                    name: 'homePhone',
                                    id: 'homePhone'
                                },{
                                    xtype: 'textfield',
                                    fieldLabel: 'Office',
                                    anchor: '95%',
                                    name: 'workPhone',
                                    id: 'workPhone'
                                }]
                            },
                            {
                                columnWidth:.5,
                                border:false,
                                layout: 'anchor',
                                defaultType: 'textfield',
                                items: [{
                                    xtype: 'textfield',
                                    fieldLabel: 'Cell',
                                    anchor: '95%',
                                    name: 'cellPhone',
                                    id: 'cellPhone'
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Other',
                                    anchor: '95%',
                                    name: 'otherPhone',
                                    id: 'otherPhone'
                                },
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'Fax',
                                    name: 'fax',
                                    anchor: '95%',
                                    id: 'fax'
                                }]
                            }]
                        }]
                            }]
                         }]
                    }]
                }
            ]
        });

        me.callParent(arguments);
    }

});