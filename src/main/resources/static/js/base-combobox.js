var BaseComboBox = function () { 
    var resolveConfig = function (defaultConfig, config) {
    	if(!defaultConfig.store.listeners){
    		defaultConfig.store.listeners = {};
    	}
    	defaultConfig.store.listeners.beforeload  = function(value, options){
      		options.params.gridStore_start = options.params[defaultConfig.id+"-store_start"];
      		options.params.gridStore_limit = options.params[defaultConfig.id+"-store_limit"];
      	};
        if (config) {
            if (config.store) {
                if (config.store.baseParams) {
                    Ext.apply(defaultConfig.store.baseParams,
                    config.store.baseParams);
                    delete config.store.baseParams;
                }
                Ext.apply(defaultConfig.store, config.store);
                delete config.store;
            }

            if (config.listeners) {
                if (!defaultConfig.listeners) {
                    defaultConfig.listeners = {};
                }

                for (var p in config.listeners) {
                    if (p) {
                        if (Ext.isFunction(defaultConfig.listeners[p]) && Ext.isFunction(config.listeners[p])) {
                            defaultConfig.listeners[p] = defaultConfig.listeners[p]
                                .createSequence(config.listeners[p]);
                        } else {
                            defaultConfig.listeners[p] = config.listeners[p];
                        }
                    }
                }

                delete config.listeners;
            }

            Ext.apply(defaultConfig, config);
        }
        return defaultConfig;
    };
    
    
    return { getPeriodDate: function (id, config) {
            var defaultConfig = {
              id: id,
              fieldLabel: 'Period',
              mode: 'remote',
              width: 148,
              triggerAction: 'all',
              minChars: 0,
              forceSelection: true,
              valueField: 'valueField',
              displayField: 'displayField',
              descriptionField: 'descriptionField',
              showDescription: true,
              pageSize: 7,
              useOriginalTpl: false,
              store: {
                  xtype: 'jsonstore',
                  storeId: id + '-store',
                  idProperty: 'valueField',
                  fields: ['valueField', 'displayField', 'descriptionField', 'valueBigDecimal1', 'valueBigDecimal2'],
                  url: application.contextPath + '/combobox.html',
                  baseParams: {
                      method: 'period'
                  }
            	}
            };
            return new Ext.ss.form.ComboBox(resolveConfig(defaultConfig, config));
        },
        getPeriodDate2: function (id, config) {
            var defaultConfig = {
                    id: id,
                    fieldLabel: 'Period',
                    mode: 'remote',
                    width: 148,
                    triggerAction: 'all',
                    minChars: 0,
                    forceSelection: true,
                    valueField: 'hyPeriodId',
                    displayField: 'hyPeriodName',
                    descriptionField: 'hyPeriodDate',
                    showDescription: true,
                    pageSize: 7,
                    useOriginalTpl: false,
                    store: {
                        xtype: 'jsonstore',
                        storeId: id + '-store',
                        idProperty: 'hyPeriodId',
                        fields: ['hyPeriodId', 'hyPeriodName', 'hyPeriodDate'],
                        url: application.contextPath + '/combobox.html',
                        baseParams: {
                            method: 'period2'
                        }
                  	}
                  };
                  return new Ext.ss.form.ComboBox(resolveConfig(defaultConfig, config));
              },
        getOrderList: function (id, config) {
            var defaultConfig = {
              id: id,
              allowBlank: false,
              fieldLabel: 'Order Name',
              mode: 'remote',
              width: 148,
              triggerAction: 'all',
              minChars: 0,
              forceSelection: true,
              valueField: 'hyOrdhId',
              displayField: 'hyOrdhName',
              descriptionField: 'hyPeriodDateString',
              showDescription: true,
              pageSize: 7,
              useOriginalTpl: false,
              store: {
                  xtype: 'jsonstore',
                  storeId: id + '-store',
                  idProperty: 'valueField',
                  fields: ['hyOrdhId', 'hyOrdhName', 'hyPeriodDateString'],
                  url: application.contextPath + '/combobox.html',
                  baseParams: {
                      method: 'orderList'
                  }
            	}
            };
            return new Ext.ss.form.ComboBox(resolveConfig(defaultConfig, config));
        } 
    };
	
}();