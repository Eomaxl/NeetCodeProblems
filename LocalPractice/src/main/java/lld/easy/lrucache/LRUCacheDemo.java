package lld.easy.lrucache;

public class LRUCacheDemo {
    static void main(){
        LRUCache<String, Integer> cache = new LRUCache(3);
        cache.put("a",1);
        cache.put("b",2);
        cache.put("c",3);
        IO.println(cache.get("a"));
        cache.put("d",4);
        IO.println(cache.get("b"));
    }
}
