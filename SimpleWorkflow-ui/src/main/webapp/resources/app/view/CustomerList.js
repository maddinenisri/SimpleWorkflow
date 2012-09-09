Ext.define('Ins.view.CustomerList', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.customerlist',
    autoShow: true,
    id: 'customerlist',
    frameHeader: false,
    title: 'Customer\'s listing',
    forceFit: true,
    personType: null,
    store: 'Customers',
    initComponent: function() {
        var me = this;
        Ext.applyIf(me, {
            viewConfig: {
                loadMask: false
            },
            dockedItems: [
                {
                    xtype: 'toolbar',
                    width: 400,
                    dock: 'top',
                    items: [
                        {
                            xtype: 'button',
                            id: 'btnEdit',
                            icon: 'resources/icons/edit.png',
                            text: 'Edit'
                        },
                        {
                            xtype: 'button',
                            id: 'btnInsert',
                            icon: 'resources/icons/insert.png',
                            text: 'Insert'
                        },
                        {
                            xtype: 'button',
                            id: 'btnDelete',
                            icon: 'resources/icons/delete.png',
                            text: 'Delete'
                        },
                        {
                            xtype: 'button',
                            id: 'btnRefresh',
                            icon: 'resources/icons/refresh.png',
                            text: 'Refresh'
                        }
                    ]
                }
            ],
            columns: [
                  {
                      xtype: 'gridcolumn',
                      dataIndex: 'idProperty',
                      text: 'Customer ID',
                      flex: 1,
          			renderer : function(value, metadata, record) {
          				myToolTipText = "<b>Tool Tip added using renderer function for customer</b>";
          				myToolTipText = myToolTipText + "<br/>First Name: "+ record.get('firstName');
                          myToolTipText = myToolTipText + "<br/>Last Name: "+ record.get('lastName');
                          myToolTipText = myToolTipText + "<br/>Email: "+ record.get('email');
                          myToolTipText = myToolTipText + "<br/>Birth Date: "+ record.get('birthDate');
                          metadata.tdAttr = 'data-qtip="' + myToolTipText + '"';
                          return value;
          			}
                  },
                  {
                      xtype: 'gridcolumn',
                      dataIndex: 'firstName',
                      text: 'Name',
                      flex: 3, 
                      renderer: function (val, meta, record) {
                      	return '<a href=customer/profile?id='+ record.data.id + '>' + record.data.firstName+' '+ record.data.lastName + '</a>';
                      }
                  },
                  {
                      xtype: 'gridcolumn',
                      dataIndex: 'occupation',
                      text: 'Occupation',
                      flex: 3
                  },
                  {
                      xtype: 'gridcolumn',
                      dataIndex: 'orgName',
                      text: 'Business Name',
                      flex: 3
                  },
                  {
                      xtype: 'gridcolumn',
                      dataIndex: 'incomeSource',
                      text: 'Income Source',
                      flex: 3
                  },
                  {
                      xtype: 'gridcolumn',
                      dataIndex: 'email',
                      text: 'Email',
                      flex: 3
                  },
                  {
                      xtype: 'gridcolumn',
                      dataIndex: 'birthDate',
                      text: 'Birth Date',
                      flex: 3
//                      renderer: Ext.util.Format.dateRenderer('n/j/Y g:i A')
                  }
            ]
        });

        me.callParent(arguments);
    }

});