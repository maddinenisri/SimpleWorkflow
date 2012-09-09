/**
 * 
 */
Ext.require('Ins.model.Search');

Ext.define('Ins.store.CustomerSearch', {
	extend: 'Ext.data.Store',
	model: 'Ins.model.Search',
	alias : 'widget.customerSearch',
	autoLoad: false,
    pageSize: 15,
    proxy: {
    	type: 'ajax',
    	url: '/InsuranceProduct/flow/search/customer',
    	reader: {
    		type: 'json',
    		totalProperty: 'totalCount',
    		root: 'customers'
    	}
    }
});