# nonrepeatsalt
8位随机不重复短链

# 特性要求

	短－省流量，够用，体验好
 
	随机－安全，难猜出我们的业务规模
  
	不重复－唯一标识
 
 	效率－短链生成效率要高
 

短链生成的公式：
shortChain= convertDecimalToBase62 (min+disorder(id))  0 ≤ id ≤ 211106232532991


我们短链的生成算法简单、效率高、容易扩展，生成的短链随机、友好，不用记录已生成短链去重



我们短链的生成的字符串组合相对于８位字符串的所有组合，没有充分利用，我们短链的使用率98.27%, 但是也是足够使用了


注意点：要使我们短链生成不重复，重点在于ID的分发不能重复
