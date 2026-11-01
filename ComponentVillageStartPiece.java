import java.util.ArrayList;
import java.util.Random;

public class ComponentVillageStartPiece extends ComponentVillageWell {
   public WorldChunkManager a;
   public int b;
   public dt c;
   public ArrayList d;
   public ArrayList e = new ArrayList();
   public ArrayList f = new ArrayList();

   public ComponentVillageStartPiece (WorldChunkManager par1WorldChunkManager, int par2, Random par3Random, long par4, long par5, ArrayList par6ArrayList, int par7) {
      super(0, par3Random, par4, par5);
      this.a = par1WorldChunkManager;
      this.d = par6ArrayList;
      this.b = par7;
   }

   public WorldChunkManager a() {
      return this.a;
   }
}
