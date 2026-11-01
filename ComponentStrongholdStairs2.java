import java.util.ArrayList;
import java.util.Random;

public class ComponentStrongholdStairs2 extends ComponentStrongholdStairs {
   public ahh a;
   public ComponentStrongholdPortalRoom b;
   public ArrayList c = new ArrayList();

   public ComponentStrongholdStairs2 (int par1, Random par2Random, long par3, long par4) {
      super(0, par2Random, par3, par4);
   }

   @Override
   public ChunkPosition a_() {
      return this.b != null ? this.b.a_() : super.a_();
   }
}
