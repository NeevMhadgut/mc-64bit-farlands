import java.util.List;
import java.util.Random;

public class ComponentStrongholdChestCorridor extends ComponentStronghold {
   private static final fx[] a = new fx[]{
      new fx(Item.BiomeGenJungle.bQ, 0, 1, 1, 10),
      new fx(Item.n.bQ, 0, 1, 3, 3),
      new fx(Item.o.bQ, 0, 1, 5, 10),
      new fx(Item.p.bQ, 0, 1, 3, 5),
      new fx(Item.aC.bQ, 0, 4, 9, 5),
      new fx(Item.U.bQ, 0, 1, 3, 15),
      new fx(Item.j.bQ, 0, 1, 3, 15),
      new fx(Item.g.bQ, 0, 1, 1, 5),
      new fx(Item.q.bQ, 0, 1, 1, 5),
      new fx(Item.BlockTNT.bQ, 0, 1, 1, 5),
      new fx(Item.ad.bQ, 0, 1, 1, 5),
      new fx(Item.TileEntityMobSpawnerRenderer.bQ, 0, 1, 1, 5),
      new fx(Item.ag.bQ, 0, 1, 1, 5),
      new fx(Item.at.bQ, 0, 1, 1, 1)
   };
   private final mg b;
   private boolean c;

   public ComponentStrongholdChestCorridor(int par1, Random par2Random, StructureBoundingBox par3StructureBoundingBox, int par4) {
      super(par1);
      this.h = par4;
      this.b = this.a(par2Random);
      this.g = par3StructureBoundingBox;
   }

   @Override
   public void a(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
      this.getNextComponentNormal((s)par1StructureComponent, par2List, par3Random, 1L, 1);
   }

   public static ComponentStrongholdChestCorridor findValidPlacement(List par0List, Random par1Random, long par2, int par3, long par4, int par5, int par6) {
      StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par2, par3, par4, -1L, -1, 0L, 5L, 5, 7L, par5);
      return a(structureboundingbox) && StructureComponent.a(par0List, structureboundingbox) == null ? new ComponentStrongholdChestCorridor(par6, par1Random, structureboundingbox, par5) : null;
   }

   @Override
   public boolean a(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox) {
      if (this.a(par1World, par3StructureBoundingBox)) {
         return false;
      }

      this.fillWithRandomizedBlocks(par1World, par3StructureBoundingBox, 0L, 0, 0L, 4L, 4, 6L, true, par2Random, StructureStrongholdPieces.b());
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, this.b, 1L, 1, 0L);
      this.placeDoor(par1World, par2Random, par3StructureBoundingBox, mg.a, 1L, 1, 6L);
      this.fillWithBlocks(par1World, par3StructureBoundingBox, 3L, 1, 2L, 3L, 1, 4L, Block.bm.bO, Block.bm.bO, false);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 5, 3L, 1, 1L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 5, 3L, 1, 5L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 5, 3L, 2, 2L, par3StructureBoundingBox);
      this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 5, 3L, 2, 4L, par3StructureBoundingBox);

      for (int i = 2; i <= 4; i++) {
         this.placeBlockAtCurrentPosition(par1World, Block.ak.bO, 5, 2L, 1, i, par3StructureBoundingBox);
      }

      if (!this.c) {
         int j = this.b(2);
         long k = this.getXWithOffset(3L, 3L);
         long l = this.getZWithOffset(3L, 3L);
         if (par3StructureBoundingBox.isVecInside(k, j, l)) {
            this.c = true;
            this.createTreasureChestAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 3L, 2, 3L, a, 2 + par2Random.nextInt(2));
         }
      }

      return true;
   }
}
