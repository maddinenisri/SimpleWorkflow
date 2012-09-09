/**
 * 
 */
Ext.define('Ins.store.Addresses', {
	extend: 'Ext.data.Store',
	model: 'Ins.model.Address',
	autoLoad: false,
    proxy: {
    	type: 'ajax',
    	url: '/SimpleWorkflow/flow/customer/getAddress',
    	method: 'GET',
    	reader: {
    		type: 'json',
    		totalProperty: 'totalCount',
    		root: 'addresses',
    		successProperty: 'success'
    	}
    }
});