import React, {useEffect} from 'react';
import {View, Text, SafeAreaView} from 'react-native';
import {WechatModule} from './lib/native';

export const App: React.FC<{}> = () => {
  useEffect(() => {
    WechatModule.registerApp('');
  }, []);
  return (
    <SafeAreaView>
      <View>
        <Text>app</Text>
      </View>
    </SafeAreaView>
  );
};
