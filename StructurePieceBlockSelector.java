import java.util.Random;

public abstract class StructurePieceBlockSelector {
   protected int a;
   protected int b;

   protected StructurePieceBlockSelector() {
   }

   public abstract void selectBlocks(Random var1, long var2, int var4, long var5, boolean var7);

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }
}
