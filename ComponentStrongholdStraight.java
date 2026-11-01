import java.util.List;
import java.util.Random;

public class ComponentStrongholdStraight extends ComponentStronghold {
   private final mg a;
   private final boolean b;
   private final boolean c;

   public ComponentStrongholdStraight(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.a = this.a(par2Random);
      this.g = par3StructureBoundingBox;
      this.b = par2Random.nextInt(2) == 0;
      this.c = par2Random.nextInt(2) == 0;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.getNextComponentNormal((s)par1StructureComponent, par2List, par3Random, 1L, 1);
      if (this.b) {
         this.getNextComponentX((s)par1StructureComponent, par2List, par3Random, 1, 2L);
      }

      if (this.c) {
         this.getNextComponentZ((s)par1StructureComponent, par2List, par3Random, 1, 2L);
      }
   }

   public static ComponentStrongholdStraight findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -1, 0L, 5L, 5, 7L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdStraight(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 4, 6L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.a, 1L, 1, 0L);
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, mg.a, 1L, 1, 6L);
      this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 1L, 2, 1L, Block.aq.bO, 0);
      this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 3L, 2, 1L, Block.aq.bO, 0);
      this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 1L, 2, 5L, Block.aq.bO, 0);
      this.randomlyPlaceBlock(par1World, par3StructureBoundingBox, par2Random, 0.1F, 3L, 2, 5L, Block.aq.bO, 0);
      if (this.b) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 0L, 1, 2L, 0L, 3, 4L, 0, 0, false);
      }

      if (this.c) {
         this.fillWithBlocks(par1World, par3StructureBoundingBox, 4L, 1, 2L, 4L, 3, 4L, 0, 0, false);
      }

      return true;
   }
}
