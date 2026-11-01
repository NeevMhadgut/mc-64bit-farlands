import java.util.List;
import java.util.Random;

public class ComponentStrongholdLeftTurn extends ComponentStronghold {
   protected final mg a;

   public ComponentStrongholdLeftTurn(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.a = this.a(par2Random);
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      if (this.h != 2 && this.h != 3) {
         this.getNextComponentZ((s)par1StructureComponent, par2List, par3Random, 1, 1L);
      } else {
         this.getNextComponentX((s)par1StructureComponent, par2List, par3Random, 1, 1L);
      }
   }

   public static ComponentStrongholdLeftTurn findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -1, 0L, 5L, 5, 5L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdLeftTurn(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 4, 4L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.a, 1L, 1, 0L);
      if (this.h != 2 && this.h != 3) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 1L, 4L, 3, 3L, 0, 0, false);
      } else {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 1L, 0L, 3, 3L, 0, 0, false);
      }

      return true;
   }
}
